package ir.miri.shop.app.entities.orders;

import ir.miri.shop.app.entities.people.Customer;
import ir.miri.shop.app.entities.products.Product;
import jakarta.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    @JoinColumn(name="product_id")
    private Product product;
    @OneToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    private long count;
    private long price;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
