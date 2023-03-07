package com.decagon.controller;

import com.decagon.entity.Applicant;
import com.decagon.entity.Customer;
import com.decagon.entity.Product;
import com.decagon.entity.Queue;
import com.decagon.enums.Gender;
import com.decagon.utils.StoreCSV;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
class CashierControllerTest {

    CashierController cashierController;
    ManagerController managerController;

    @BeforeEach
    void setUp(){
        cashierController = new CashierController();
        managerController = new ManagerController();

        List<Applicant> applicantList = new ArrayList<>();
        Applicant applicant1 = new Applicant("1","Daniel Obaba",25, Gender.MALE,3,"BSc");
        applicantList.add(applicant1);
        managerController.checkRequirement(applicantList);
        managerController.hireCashier("1");
    }

    @Test
    void sellProductWithWrongId(){
//        cashierController = new CashierController();

        PriorityBlockingQueue<Queue> priorityQueue = new PriorityBlockingQueue<>();

        Customer customer1 = new Customer("634","chris",23, Gender.MALE,900);
        customer1.setCartList(StoreCSV.getProductsFromCSV().get(1).getProductID(),
                StoreCSV.getProductsFromCSV().get(1).getProductName(), 3);

        priorityQueue.add(new Queue(customer1,customer1.getCartList()));

        cashierController.sellProduct("11", priorityQueue);
    }

    @Test
    void sellProductWithCorrectId(){

        PriorityBlockingQueue<Queue>  priorityQueue = new PriorityBlockingQueue<>();

        Customer customer1 = new Customer("634","chris",23, Gender.MALE,900);
        customer1.setCartList(StoreCSV.getProductsFromCSV().get(1).getProductID(),
                StoreCSV.getProductsFromCSV().get(1).getProductName(), 3);

        priorityQueue.add(new Queue(customer1,customer1.getCartList()));

        cashierController.sellProduct("10", priorityQueue);
    }

    @Test
    void checkPriorityBySize(){

        PriorityBlockingQueue<Queue> priorityQueue = new PriorityBlockingQueue<>();

        Customer customer1 = new Customer("634","chris",23, Gender.MALE,900);
        customer1.setCartList(StoreCSV.getProductsFromCSV().get(1).getProductID(),
                StoreCSV.getProductsFromCSV().get(1).getProductName(), 3);

        priorityQueue.add(new Queue(customer1,customer1.getCartList()));

        Customer customer2 = new Customer("567","John",23, Gender.MALE,900);
        customer2.setCartList(StoreCSV.getProductsFromCSV().get(0).getProductID(),
                StoreCSV.getProductsFromCSV().get(0).getProductName(), 3);
        customer2.setCartList(StoreCSV.getProductsFromCSV().get(1).getProductID(),
                StoreCSV.getProductsFromCSV().get(1).getProductName(), 2);

        priorityQueue.add(new Queue(customer2,customer2.getCartList()));

        cashierController.sellProduct("10", priorityQueue);
    }

}
 **/