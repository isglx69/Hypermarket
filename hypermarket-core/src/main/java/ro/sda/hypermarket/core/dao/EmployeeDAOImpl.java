package ro.sda.hypermarket.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ro.sda.hypermarket.core.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Employee addEmployee(Employee object) {
        sessionFactory.getCurrentSession().save(object);
        return object;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Criterion byId = Restrictions.idEq(id);
        List<Employee> allResults = sessionFactory.getCurrentSession().createCriteria(Employee.class).add(byId).list();
        if (allResults.size() > 0) {
            return allResults.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createCriteria(Employee.class).list();
    }

    @Override
    public Employee updateEmployee(Employee object) {
        Long id = (Long) sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().save(object);
        sessionFactory.getCurrentSession().flush();
        return getEmployeeById(id);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Transaction tr = sessionFactory.getCurrentSession().beginTransaction();
        Employee object = (Employee) sessionFactory.getCurrentSession().get(Employee.class, employee.getId());
        sessionFactory.getCurrentSession().delete(object);
        sessionFactory.getCurrentSession().flush();
        tr.commit();
    }
}
