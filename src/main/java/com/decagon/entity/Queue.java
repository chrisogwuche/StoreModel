package com.decagon.entity;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Queue implements Comparable<Queue>{

    private Customer customer;
    private Vector<Product> productList;
    private PriorityBlockingQueue<Queue> priorityQueue = new PriorityBlockingQueue<>();

//    private ConcurrentLinkedQueue<Queue> priorityQueue = new ConcurrentLinkedQueue<>();

    private PriorityBlockingQueue<Queue> priorityQueue2 = new PriorityBlockingQueue<>();

    public Queue(){};
    public Queue(Customer customer,Vector<Product> productList){
        this.customer = customer;
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vector<Product> getProductList() {
        return productList;
    }

    public void setProductList(Vector<Product> productList) {
        this.productList = productList;
    }


    @Override
    public int compareTo(@NotNull Queue o) {
       if(this.productList.size() > o.getProductList().size()){
           return -1;
       }
       else if (productList.size() < o.getProductList().size()){
           return 1;
        }
       return 0;

    }

    public void setQueue(Queue queue) {
        priorityQueue.add(queue);
    }

    public  PriorityBlockingQueue<Queue> getQueue() {
        return priorityQueue;
    }


    public void setQueue2(Queue queue) {
        priorityQueue2.add(queue);
    }

    public PriorityBlockingQueue<Queue> getQueue2() {
        return priorityQueue2;
    }


    @Override
    public String toString() {
        return "Queue{" +
                "customer=" + customer +
                ", productList=" + productList+
                '}';
    }
}
