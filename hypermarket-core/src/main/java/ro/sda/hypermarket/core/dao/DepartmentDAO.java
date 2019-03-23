package ro.sda.hypermarket.core.dao;

import ro.sda.hypermarket.core.entity.Department;
import java.util.List;

public interface DepartmentDAO {
    public Department addDepartment(Department department);
    public Department getDepartmentById(Long id);
    public List<Department> getAllDepartments();
    public Department updateDepartment(Department department);
    public void deleteDepartment(Department department);
}
