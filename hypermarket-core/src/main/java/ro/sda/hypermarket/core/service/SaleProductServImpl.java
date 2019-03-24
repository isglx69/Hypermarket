package ro.sda.hypermarket.core.service;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.entity.SaleProduct;
import ro.sda.hypermarket.core.repository.SaleProductRepository;

import java.util.List;

@Service("saleProductService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class SaleProductServImpl implements SaleProductService{

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private SaleProductRepository saleProductRepository;

    @Override
    @Transactional
    public SaleProduct addSaleProduct(SaleProduct object,boolean useHibernate) {
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
