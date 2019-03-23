package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Department;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Department addDepartment(Department object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public Department getDepartmentById(Long id) {
        Criterion byId = Restrictions.idEq(id);
        List<Department> allResults = sessionFactory.getCurrentSession().createCriteria(Department.class).add(byId).list();
        if (allResults.size() > 0) {
            return allResults.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Department> getAllDepartments() {
        return sessionFactory.getCurrentSession().createCriteria(Department.class).list();
    }

    @Override
    public Department updateDepartment(Department object) {
        Long id = (Long) sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().flush();
        return getDepartmentById(id);
    }

    @Override
    public void deleteDepartment(Department department) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Department object = (Department) sessionFactory.getCurrentSession().get(Department.class, department.getId());
        sessionFactory.getCurrentSession().delete(object);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
