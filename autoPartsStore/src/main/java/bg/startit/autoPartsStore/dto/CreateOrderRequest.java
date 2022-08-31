package bg.startit.autoPartsStore.dto;

import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.User;

import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateOrderRequest {

    private Integer id;
    @Min(value = 1, message = "Amount can't be negative number!")
    private Integer amount;
    @Min(value = 1, message = "Price can't be negative number!")
    private BigDecimal price;
    private LocalDateTime orderDate;
    private User client;
    private Product product;

    public Integer getId() {
        return id;
    }

    public CreateOrderRequest setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getAmount() {
        return amount;
    }

    public CreateOrderRequest setAmount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CreateOrderRequest setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public CreateOrderRequest setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public User getClient() {
        return client;
    }

    public CreateOrderRequest setClient(User client) {
        this.client = client;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public CreateOrderRequest setProduct(Product product) {
        this.product = product;
        return this;
    }
}
