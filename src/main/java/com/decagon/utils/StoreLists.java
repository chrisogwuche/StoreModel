package com.decagon.utils;
import com.decagon.entity.Applicant;
import com.decagon.entity.Product;
import com.decagon.entity.SalesRecord;
import com.decagon.entity.Staffs;
import com.decagon.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class StoreLists {
    private static Vector<SalesRecord> salesRecordList = new Vector<>();
    private static Vector<Applicant> qualifiedApplicant = new Vector<>();
    private static Vector<Staffs> cashierList = new Vector<>();

    public static void setSalesRecordList(String id,String name, Product product){
        salesRecordList.add(new SalesRecord(id,name, product));
    }

    public static Vector<SalesRecord> getSalesRecordList(){
        return salesRecordList;
    }

    public static Vector<Applicant> getQualifiedApplicant() {
        return qualifiedApplicant;
    }

    public static void setQualifiedApplicant(Applicant applicant) {
        StoreLists.qualifiedApplicant.add(applicant);
    }

    public static Vector<Staffs> getCashierList() {
        return cashierList;
    }

    public static void setCashierList(String id, Applicant applicant) {
        StoreLists.cashierList.add(new Staffs(id,applicant.getName(),applicant.getAge(),applicant.getGender()
                ,applicant.getQualification(), Role.CASHIER,true));
    }
}
