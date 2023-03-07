package com.decagon.entity;

public class Store {
    private static double accountBalance = 0;
    private static double profitOrLoss = 0;
    private static double totalSales = 0;
    private static double totalCost = 0;



    public Store(){}

    public static void setTotalCost(double totalcost) {
        totalCost += totalcost;
    }
    public static void setTotalSales(double totalSells) {
        totalSales += totalSells;
    }
    public static void setAccountBalance() {
        accountBalance = totalSales;
    }
    public static void setProfitOrLoss() {
        profitOrLoss += (totalSales-totalCost);
    }
    public static double getAccountBalance(){
        return accountBalance;
    }
    public static double getProfitOrLoss(){
        return profitOrLoss;
    }
    public static double getTotalSales(){
        return totalSales;
    }
    public static double getTotalCost(){
        return totalCost;
    }
}
