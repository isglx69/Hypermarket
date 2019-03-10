package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sales", schema = "hypermarket")

public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "invoice_no", length = 20, nullable = false)
    private String invoiceNo;

    @Column(name = "sale_date", nullable = false)
    private String saleDate;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @ManyToOne
    @JoinColumn (name = "employee_id", nullable = false)
    private Employee employeeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Employee getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Employee employerId) {
        this.employerId = employerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sale sale = (Sale) o;
        return Objects.equals(id, sale.id) &&
                Objects.equals(invoiceNo, sale.invoiceNo) &&
                Objects.equals(saleDate, sale.saleDate) &&
                Objects.equals(clientId, sale.clientId) &&
                Objects.equals(employerId, sale.employerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceNo, saleDate, clientId, employerId);
    }
}
