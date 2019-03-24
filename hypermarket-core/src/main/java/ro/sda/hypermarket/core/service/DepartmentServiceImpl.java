package ro.sda.hypermarket.core.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.DepartmentDAO;
import ro.sda.hypermarket.core.entity.Department;
import ro.sda.hypermarket.core.repository.DepartmentRepository;

import java.util.List;

@Service("departmentService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public Department addDepartment(Department department, boolean useHibernate) {
        if (useHibernate) {
            return departmentDAO.addDepartment(department);
        }
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        return getCurrentSession().load(Department.class, id);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentDAO.updateDepartment(department);
    }

    @Override
    public void deleteDepartment(Department department) {
        departmentDAO.deleteDepartment(department);
    }
}
