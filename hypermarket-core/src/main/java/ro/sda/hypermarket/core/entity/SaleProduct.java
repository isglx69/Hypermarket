package ro.sda.hypermarket.core.entity;

import ro.sda.hypermarket.core.base.BaseEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "sale_product", schema = "hypermarket")

public class SaleProduct extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private double quantity;

    @OneToOne
    @JoinColumn(name="sale_id",nullable=false)
    private Sale sale;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SaleProduct that = (SaleProduct) o;
        return Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(super.getId(), that.getId()) &&
                Objects.equals(product, that.product) &&
                Objects.equals(sale, that.sale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), product, quantity, sale);
    }
}
