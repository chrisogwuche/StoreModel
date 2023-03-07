package com.decagon.entity;

public class SalesRecord {

    private String id;
    private String name;
    private Product product;

    public SalesRecord(String id,String name,Product product){
        this.id = id;
        this.name = name;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "SalesRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", product=" + product.toString() +
                '}';
    }
}
