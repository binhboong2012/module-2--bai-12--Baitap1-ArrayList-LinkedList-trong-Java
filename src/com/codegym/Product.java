package com.codegym;

public class Product {
    private String id;
    private String name;
    private long price;
    private String description;

    public Product() {
    }

    public Product(String id, String name, long price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(String id, String name, long price) {
        this(id, name, price, "");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString(){
        return String.format("%-10s %-40s %-15d %s", id, name, price, description);
    }
}
