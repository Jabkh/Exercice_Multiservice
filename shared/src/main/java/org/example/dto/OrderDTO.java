package org.example.dto;

import java.util.List;

public class OrderDTO {
    private Long orderId;
    private Long userId;
    private List<String> products;

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, Long userId, List<String> products) {
        this.orderId = orderId;
        this.userId = userId;
        this.products = products;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}