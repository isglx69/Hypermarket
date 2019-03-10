package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="prod_categories",schema="hypermarket")
public class ProductCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",length = 40,nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

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

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
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
        ProductCategories that = (ProductCategories) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(products, that.products) &&
                Objects.equals(manager, that.manager);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, products, manager);
    }
}
