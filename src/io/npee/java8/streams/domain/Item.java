package io.npee.java8.streams.domain;

public class Item {
    private final Long id;
    private String name;
    private Integer price;
    private String description;

    public Item(Long id, String name, Integer price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
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

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id = " + id +
                   ", name = " + name +
                   ", price = " + price +
                   ", description = " + description;

    }
}
