package ro.sda.hypermarket.core.service;

import java.util.List;
import ro.sda.hypermarket.core.entity.Employee;

public interface EmployeeService {
    public Employee addEmployee(Employee employee, boolean useHibernate);
    public Employee getEmployeeById(Long id);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
