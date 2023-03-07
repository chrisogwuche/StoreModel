package com.decagon.entity;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productID;
    private  String productName;
    private volatile int unit;
    private double costPrice;
    private double sellingPrice;
    private String  category;

    public Product (){}
    public Product(String productID,String productName,int unit,double costPrice,double sellingPrice,String category){
        this.productID = productID;
        this.productName = productName;
        this.unit = unit;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this. category =  category;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getCategory() {
        return  category;
    }

    public void setCategory(String provision) {
        this. category = provision;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", unit='" + unit + '\'' +
//                ", costPrice='" + costPrice + '\'' +
//                ", sellingPrice='" + sellingPrice + '\'' +
//                ", category='" + category + '\'' +
                '}';
    }

}
