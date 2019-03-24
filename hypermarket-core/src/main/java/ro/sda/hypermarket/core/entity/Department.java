package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "departments", schema = "hypermarket")

public class Department extends BaseEntity {

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Client manager;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getManager() {
        return manager;
    }

    public void setManager(Client manager) {
        this.manager = manager;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(super.getId(), that.getId()) &&
                Objects.equals(name, that.name) &&
                Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name, manager);
    }
}
