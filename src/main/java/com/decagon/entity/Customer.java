package com.decagon.entity;

import com.decagon.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Customer extends Users{
    private double money;
    private Vector<Product> cartList = new Vector<>();

    public Customer() {
    }

    public Customer(String id, String name, int age, Gender gender, double money) {
        super(id, name, age, gender);
        this.money = money;
    }

    public void setCartList(String id,String productName,int unit,double costPrice,double sellingPrice,String category)
    {
        cartList.add(new Product(id,productName,unit,costPrice,sellingPrice,category));
    }
    public Vector<Product> getCartList(){
        return cartList;
    }
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    @Override
    public String toString(){
        return ""+super.toString();
    }

}
