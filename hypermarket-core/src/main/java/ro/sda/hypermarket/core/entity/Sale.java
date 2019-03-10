package ro.sda.hypermarket.core.entity;

import javax.persistence.*;
import java.util.Date;
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
    private Date saleDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="client_id")
    private Client clientId;

    @ManyToOne(cascade = CascadeType.ALL)
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

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Client getClientId() {
        return clientId;
    }

    public void setClientId(Client clientId) {
        this.clientId = clientId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
                Objects.equals(employeeId, sale.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceNo, saleDate, clientId, employeeId);
    }
}
