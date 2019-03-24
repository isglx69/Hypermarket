package ro.sda.hypermarket.core.service;
import ro.sda.hypermarket.core.entity.Department;
import java.util.List;

public interface DepartmentService {
    public Department addDepartment(Department department, boolean useHibernate);
    public Department getDepartmentById(Long id);
    public List<Department> getAllDepartments();
    public Department updateDepartment(Department department);
    public void deleteDepartment(Department department);
}
