package com.decagon.service.serviceImpl;

import com.decagon.entity.*;
import com.decagon.service.CashierService;
import com.decagon.utils.StoreCSV;
import com.decagon.utils.StoreLists;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;


public class CashierServiceImpl implements CashierService {
    @Override
    public void setConfirmBuyerList(Staffs cashier, Queue queue) {

        double totalSellingPrice = 0;
        boolean boolFlag = true;
        int newValue = 0;

        if (queue != null)

        for (Product customerProduct : queue.getProductList()) {
            totalSellingPrice += (customerProduct.getUnit() * customerProduct.getSellingPrice());

            for (Product storeProduct : StoreCSV.getProductsFromCSV()) {

                if (customerProduct.getProductID().equals(storeProduct.getProductID())) {
                    newValue = storeProduct.getUnit() - customerProduct.getUnit();

                    if (storeProduct.getUnit() == 0) {
                        System.out.println(customerProduct.getProductName() + " OUT OF STOCK.... CUSTOMER "
                                + queue.getCustomer().getName() + " REQUEST CANNOT BE PROCESSED" + "\n");
                        boolFlag = false;
                        break;
                    }
                    if (newValue >= 0) {
                        boolFlag = true;
                        break;
                    }
                    else {
                        System.out.println(customerProduct.getProductName() + " have available unit of "
                                + storeProduct.getUnit() + " . Demand is high. Please select again..... CUSTOMER "
                                + queue.getCustomer().getName() + " REQUEST CANNOT BE PROCESSED" + "\n");
                        boolFlag = false;
                        break;
                    }
                }

            }
            if (!boolFlag) {
                break;
            }
        }

        if (boolFlag && queue != null) {

            sell(cashier, queue, totalSellingPrice);
        }

    }


    public void sell(Staffs cashier, Queue queue, double totalPrice) {
        double totalCostPrice = 0;
        String receipt = "";


        if (totalPrice <= queue.getCustomer().getMoney()) {

            // update customer money
            queue.getCustomer().setMoney(queue.getCustomer().getMoney() - totalPrice);

            for (Product customerProduct : queue.getProductList()) {
                totalCostPrice += (customerProduct.getUnit() * customerProduct.getCostPrice());
                int row = 0;

               for (Product storeProduct : StoreCSV.getProductsFromCSV()) {
                    row += 1;

                    if (customerProduct.getProductID().equals(storeProduct.getProductID())) {
                        int newUnit = storeProduct.getUnit() - customerProduct.getUnit();
                        storeProduct.setUnit(newUnit);

                        // write back to StoreCSV the change in Unit
                        try {
                            StoreCSV.updateStoreCSV(String.valueOf(newUnit), row, 2);
                        } catch (IOException | CsvException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    }
                }

                // save staff ID,staff name and with buyer product
                StoreLists.setSalesRecordList(cashier.getId(), cashier.getName(), customerProduct); // Association implemented

                receipt += customerProduct.getProductName() + " : " + customerProduct.getSellingPrice() + "$" +
                        " : " + customerProduct.getUnit() + " unit/units" + "\n";
            }

            Store.setTotalCost(totalCostPrice);
            Store.setTotalSales(totalPrice);

            Receipt(receipt, totalPrice);
        }
        else{
            System.out.println("You do not have sufficient money in your wallet. Please add money.");
        }
    }

    public void Receipt(String receipt, double totalSellingPrice) {
        System.out.println("RECEIPT \n" + "----------------------------------------------" + "\n" +
                receipt + "\n" + "--------------------------------------------------" + "\n" +
                "TOTAL: " + totalSellingPrice + "$");
        System.out.println("------------------------------------------------------");
    }

}