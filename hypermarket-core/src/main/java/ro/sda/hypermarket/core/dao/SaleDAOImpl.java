package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Sale;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional

public class SaleDAOImpl implements SaleDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Sale addSale(Sale object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public Sale getSaleById(Long id) {
        Criterion byId = Restrictions.idEq(id);
        List<Sale> allResults = sessionFactory.getCurrentSession().createCriteria(Sale.class).add(byId).list();
        if(allResults.size() > 0) {
            return allResults.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Sale> getAllSales() {
        return sessionFactory.getCurrentSession().createCriteria(Sale.class).list();
    }

    @Override
    public Sale updateSale(Sale object) {
        Long id = (Long) sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().flush();
        return getSaleById(id);
    }

    @Override
    public void deleteSale(Sale sale) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Sale object = (Sale) sessionFactory.getCurrentSession().get(Sale.class, sale.getId());
        sessionFactory.getCurrentSession().delete(object);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
