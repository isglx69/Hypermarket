package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.lang.reflect.GenericArrayType;
import java.util.Objects;

@Entity
@Table(name = "suppliers", schema = "hypermarket")

public class Supplier extends BaseEntity {

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "contact_no", length = 20)
    private String contactNo;

    @Column(name = "city", length = 30)
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(super.getId(), supplier.getId()) &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(contactNo, supplier.contactNo) &&
                Objects.equals(city, supplier.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name, contactNo, city);
    }
}
