package ro.sda.hypermarket.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.hypermarket.core.dao.EmployeeDAO;
import ro.sda.hypermarket.core.entity.Employee;
import ro.sda.hypermarket.core.repository.EmployeeRepository;
import java.util.List;

@Service("employeeService")
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Employee addEmployee(Employee employee, boolean useHibernate) {
        if (useHibernate) {
            return employeeDAO.addEmployee(employee);
        }
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDAO.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }
}
