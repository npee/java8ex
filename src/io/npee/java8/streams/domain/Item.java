package io.npee.java8.streams.domain;

import java.time.LocalDateTime;

public class Item {
    private final Long id;
    private String name;
    private Integer price;
    private String description;
    private final LocalDateTime updatedAt;
    private User updatedBy;

    public Item(Long id, String name, Integer price, String description, User updatedBy) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.updatedAt = LocalDateTime.now();
        this.updatedBy = updatedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
