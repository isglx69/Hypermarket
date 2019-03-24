package ro.sda.hypermarket.core.entity;


import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="products",schema = "hypermarket")
public class Product extends BaseEntity {

   @Column(name = "name",length=40,nullable = false)
    private String name;

   @Column(name="supplier_price", length=40,nullable = false)
    private Long supplier_price;

    @Column(name="stock", length=40,nullable = true)
    private Integer stock;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="category_id")
    private ProductCategories category;


    @Column(name="vending_price", nullable = true)
    private Long vending_price;

    @OneToMany(mappedBy = "product")
    private Set<SaleProduct> saleProduct;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSupplier_price() {
        return supplier_price;
    }

    public void setSupplier_price(Long supplier_price) {
        this.supplier_price = supplier_price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public ProductCategories getCategory() {
        return category;
    }

    public void setCategory(ProductCategories category) {
        this.category = category;
    }

    public Long getVending_price() {
        return vending_price;
    }

    public void setVending_price(Long vending_price) {
        this.vending_price = vending_price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(super.getId(), product.getId()) &&
                Objects.equals(name, product.name) &&
                Objects.equals(supplier_price, product.supplier_price) &&
                Objects.equals(stock, product.stock) &&
                Objects.equals(supplier, product.supplier) &&
                Objects.equals(category, product.category) &&
                Objects.equals(vending_price, product.vending_price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name, supplier_price, stock, supplier, category, vending_price);
    }
}
