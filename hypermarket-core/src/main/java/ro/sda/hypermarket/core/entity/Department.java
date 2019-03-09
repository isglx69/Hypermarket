package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "hypermarket")

public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Employee manager;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Department that = (Department) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, manager);
    }
}
