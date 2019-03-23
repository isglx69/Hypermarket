package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public Employee addEmployee(Employee employee);
    public Employee getEmployeeById(Long id);
    public List<Employee> getAllEmployees();
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
