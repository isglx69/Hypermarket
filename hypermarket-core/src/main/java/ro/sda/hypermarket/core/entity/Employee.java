package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees", schema = "hypermarket")

public class Employee extends BaseEntity {

    @Column(name = "first_name", length = 20, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 20, nullable = false)
    private String lastName;

    @Column(name = "salary")
    private int salary;

    @Column(name = "job_title", length = 20, nullable = false)
    private String jobTitle;

    @Column(name = "dept_id", nullable = false)
    private Long deptId;

    @Column(name = "city", length = 30, nullable = false)
    private String city;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                Objects.equals(super.getId(), employee.getId()) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(jobTitle, employee.jobTitle) &&
                Objects.equals(deptId, employee.deptId) &&
                Objects.equals(city, employee.city) &&
                Objects.equals(manager, employee.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), firstName, lastName, salary, jobTitle, deptId, city, manager);
    }
}
