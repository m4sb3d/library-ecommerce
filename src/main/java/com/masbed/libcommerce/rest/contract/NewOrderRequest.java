package com.masbed.libcommerce.rest.contract;

import com.masbed.libcommerce.domain.Item;
import com.masbed.libcommerce.domain.Order;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NewOrderRequest {

    @NotNull
    @Positive
    private BigDecimal total;

    @NotNull
    @Size(min = 1)
    @Valid
    private List<NewItemRequest> newItemRequestList;

    @Deprecated
    public NewOrderRequest(){

    }

    public NewOrderRequest(@NotNull @Positive BigDecimal total,
                           @NotNull @Size(min = 1) @Valid List<NewItemRequest> newItemRequestList) {
        this.total = total;
        this.newItemRequestList = newItemRequestList;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public List<NewItemRequest> getNewItemRequestList() {
        return newItemRequestList;
    }

    public Order toModel(){
        List<Item> itemList = new ArrayList<>();
        newItemRequestList.forEach(newItemRequest -> itemList.add(newItemRequest.toModel()));
        return new Order(itemList, total);
    }
}
