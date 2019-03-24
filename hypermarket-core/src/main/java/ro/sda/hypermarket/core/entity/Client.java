package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="clients", schema = "hypermarket")

public class Client extends BaseEntity {

    @Column(name="name")
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(super.getId(), client.getId()) &&
                Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name);
    }
}
