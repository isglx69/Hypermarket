package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.SaleProduct;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SaleProductDAOImpl implements SaleProductDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public SaleProduct addSaleProduct(SaleProduct object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public SaleProduct getSaleProductById(Long id) {
        Criterion byId = Restrictions.idEq(id);
        List<SaleProduct> allResults = sessionFactory.getCurrentSession().createCriteria(SaleProduct.class).add(byId).list();
        if(allResults.size() > 0) {
            return allResults.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<SaleProduct> getAllSaleProducts() {
        return sessionFactory.getCurrentSession().createCriteria(SaleProduct.class).list();
    }

    @Override
    public SaleProduct updateSaleProduct(SaleProduct object) {
        Long id = (Long) sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().flush();
        return getSaleProductById(id);
    }

    @Override
    public void deleteSaleProduct(SaleProduct saleProduct) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        SaleProduct object = (SaleProduct) sessionFactory.getCurrentSession().get(SaleProduct.class, saleProduct.getId());
        sessionFactory.getCurrentSession().delete(object);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}

