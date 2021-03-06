package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Supplier;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Supplier addSupplier(Supplier object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public Supplier getSupplierById(Long id) {
        Criterion byId = Restrictions.idEq(id);
        List<Supplier> allResults = sessionFactory.getCurrentSession().createCriteria(Supplier.class).add(byId).list();
        if(allResults.size() > 0) {
            return allResults.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return sessionFactory.getCurrentSession().createCriteria(Supplier.class).list();
    }

    @Override
    public Supplier updateSupplier(Supplier object) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier supplier = getSupplierById(object.getId());
        sessionFactory.getCurrentSession().merge(object);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
        return getSupplierById(object.getId());
    }

    @Override
    public void deleteSupplier(Supplier supplier) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Supplier object = (Supplier) sessionFactory.getCurrentSession().get(Supplier.class, supplier.getId());
        sessionFactory.getCurrentSession().delete(object);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}



