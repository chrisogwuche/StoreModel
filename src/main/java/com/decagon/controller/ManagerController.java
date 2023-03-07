package com.decagon.controller;
import com.decagon.entity.Applicant;
import com.decagon.entity.SalesRecord;
import com.decagon.entity.Staffs;
import com.decagon.entity.Store;
import com.decagon.service.ManagerService;
import com.decagon.service.serviceImpl.ManagerServiceImpl;
import com.decagon.utils.StoreLists;
import java.util.List;

public class ManagerController {

    ManagerService managerService = new ManagerServiceImpl();

    public String checkRequirement(List<Applicant> applicantList){

        managerService.setCheckRequirement(applicantList);

        if(StoreLists.getQualifiedApplicant().isEmpty()){
            return "No applicant meet the requirement";
        }
        else{
            return "Requirement confirmed";
        }
    }

    public String hireCashier(String applicantID){
        if(!managerService.setHireCashier(applicantID)){
            return "Applicant not found!";
        }
        else{
            return "Cashier hired";
        }
    }

    public String sackCashier(String cashierID){
        if(!managerService.setSackCashier(cashierID)){
            return "Wrong ID input";
        }
        else{
            return "Cashier sacked";
        }
    }

    public void checkCashierList(){
        for(Staffs cashier: StoreLists.getCashierList()){
            System.out.println(cashier.toString());
        }
    }

    public void checkRecord(){
        for(SalesRecord record: StoreLists.getSalesRecordList()){
            System.out.println(record.toString());
        }
    }
    public void storeAccountDetails(){
        Store.setAccountBalance();
        Store.setProfitOrLoss();
        System.out.println("STORE ACCOUNT BALANCE: " +Store.getAccountBalance() +"$");
        System.out.println("PROFIT OR LOSS: " +Store.getProfitOrLoss()+"$");
        System.out.println("STORE TOTAL SALES: " +Store.getTotalSales()+"$");
        System.out.println("STORE TOTAL COSTS: " +Store.getTotalCost()+"$");
    }

}
