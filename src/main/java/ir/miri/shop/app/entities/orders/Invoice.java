package ir.miri.shop.app.entities.orders;

import ir.miri.shop.app.entities.people.Customer;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Invoice {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    @OneToMany
    @JoinColumn(name="order_items")
    private List<OrderItem> orderItems;
    private Date invoiceDate;
    private Date payedDate;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Date getPayedDate() {
        return payedDate;
    }

    public void setPayedDate(Date payedDate) {
        this.payedDate = payedDate;
    }
}
