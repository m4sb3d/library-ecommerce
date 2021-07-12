package com.masbed.libcommerce.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @NotNull
    private Purchase purchase;

    @Size(min = 1)
    @ElementCollection
    private List<Item> itemList;

    @NotNull
    @Positive
    private BigDecimal total;

    @Deprecated
    public Order(){}

    public Order( @Size(min = 1) List<Item> itemList, @NotNull @Positive BigDecimal total) {
        this.itemList = itemList;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public BigDecimal getTotal() {
        return total;
    }
}
