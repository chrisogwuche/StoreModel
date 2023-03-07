package com.decagon;

import com.decagon.controller.CashierController;
import com.decagon.controller.ManagerController;
import com.decagon.entity.*;
import com.decagon.entity.Queue;
import com.decagon.enums.Gender;
import com.decagon.utils.StoreCSV;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
public class Main {
    public static void main(String []arg){

        ManagerController managerServices = new ManagerController();
        Queue queue = new Queue();
        Product product = new Product();


        ArrayList<Applicant> applicantList = new ArrayList<>();
        Applicant applicant1 =
                new Applicant("1","Daniel Obaba",25,Gender.MALE,3,"BSc");
        Applicant applicant2 =
                new Applicant("2","Felix Tuba",18,Gender.MALE,1,"WAEC");
        Applicant applicant3 =
                new Applicant("3","Maduka Ayo",30,Gender.FEMALE,4,"MSC");
        Applicant applicant4 =
                new Applicant("4","Jude Ori",45,Gender.FEMALE,1,"MSC");
        applicantList.add(applicant1);
        applicantList.add(applicant2);
        applicantList.add(applicant3);
        applicantList.add(applicant4);

        
       // check Hiring requirement
        System.out.println(managerServices.checkRequirement(applicantList));

        System.out.println("========================================================================================");
        // hire Qualified Applicant with ID = 1;
        System.out.println(managerServices.hireCashier("1"));
        System.out.println(managerServices.hireCashier("3"));

        System.out.println("========================================================================================");
        // check Cashier's List
        managerServices.checkCashierList();

//        System.out.println("========================================================================================");
//         new cashier ID = 10
//        System.out.println(managerServices.sackCashier("10"));
//


        System.out.println("========================================================================================");


        Customer customer1 = new Customer("634","chris",23, Gender.MALE,1000);
        customer1.setCartList(StoreCSV.getProductsFromCSV().get(0).getProductID(),
                StoreCSV.getProductsFromCSV().get(0).getProductName(), 1,
                StoreCSV.getProductsFromCSV().get(0).getCostPrice(),
                StoreCSV.getProductsFromCSV().get(0).getSellingPrice(),
                StoreCSV.getProductsFromCSV().get(0).getCategory());

        queue.setQueue(new Queue(customer1,customer1.getCartList()));


        Customer customer2 = new Customer("424","faith",12, Gender.FEMALE,1000);
        customer2.setCartList(StoreCSV.getProductsFromCSV().get(0).getProductID(),
                StoreCSV.getProductsFromCSV().get(0).getProductName(), 1,
                StoreCSV.getProductsFromCSV().get(0).getCostPrice(),
                StoreCSV.getProductsFromCSV().get(0).getSellingPrice(),
                StoreCSV.getProductsFromCSV().get(0).getCategory()
                );

        queue.setQueue(new Queue(customer2,customer2.getCartList()));



        Customer customer3 = new Customer("754","mike",42, Gender.MALE,1500);
        customer3.setCartList(StoreCSV.getProductsFromCSV().get(0).getProductID(),
                StoreCSV.getProductsFromCSV().get(0).getProductName(), 1,
                StoreCSV.getProductsFromCSV().get(0).getCostPrice(),
                StoreCSV.getProductsFromCSV().get(0).getSellingPrice(),
                StoreCSV.getProductsFromCSV().get(0).getCategory());


        queue.setQueue2(new Queue(customer3,customer3.getCartList()));






        System.out.println("CUSTOMER 1 WALLET BALANCE BEFORE TRANSACTION: " + customer1.getMoney());
        System.out.println("CUSTOMER 2 WALLET BALANCE BEFORE TRANSACTION: " + customer2.getMoney());
        System.out.println("CUSTOMER 3 WALLET BALANCE BEFORE TRANSACTION: " + customer3.getMoney());

        System.out.println("========================================================================================");


        CashierController cashierServices1 = new CashierController("10",queue.getQueue());
        CashierController cashierServices2 = new CashierController("11",queue.getQueue2());


        Thread thread1 = new Thread(cashierServices1);
        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//
        Thread thread2 = new Thread(cashierServices2);
        thread2.start();


        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



//        cashierServices.sellProduct("10",queue.getQueue());
//        cashierServices.sellProduct("11",queue.getQueue2());
//        cashierServices.sellProduct("11",priorityQueue1);
//        cashierServices.sellProduct("10",priorityQueue3);



//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//

        System.out.println("========================================================================================");
        // CHECK SALES RECORD
        managerServices.checkRecord();
        System.out.println("========================================================================================");
        // CHECK SHOP ACCOUNT DETAILS
        managerServices.storeAccountDetails();

        System.out.println("========================================================================================");
        System.out.println("CUSTOMER 1 WALLET BALANCE: " + customer1.getMoney());
        System.out.println("CUSTOMER 2 WALLET BALANCE: " + customer2.getMoney());
        System.out.println("CUSTOMER 3 WALLET BALANCE: " + customer3.getMoney());



    }
}
