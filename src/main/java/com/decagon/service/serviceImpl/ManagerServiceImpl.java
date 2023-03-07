package com.decagon.service.serviceImpl;

import com.decagon.entity.Applicant;
import com.decagon.entity.Staffs;
import com.decagon.service.ManagerService;
import com.decagon.utils.StoreLists;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    private static int IdGenerator = 10;

    @Override
    public void setCheckRequirement(@NotNull List<Applicant>applicantList){

        for(Applicant applicant: applicantList){
            if(applicant.getAge() > 19 && applicant.getAge() < 35 && applicant.getYearsOfExperience() > 2)
            {
                StoreLists.setQualifiedApplicant(applicant);
            }
        }
    }

    @Override
    public boolean setHireCashier(String cashierID){

        for(Applicant applicant: StoreLists.getQualifiedApplicant()){

            if(applicant.getId().equals(cashierID)){
                StoreLists.setCashierList(String.valueOf(IdGenerator),applicant);
                IdGenerator+=1;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setSackCashier(String cashierID){
        for(Staffs staff: StoreLists.getCashierList()){
            if(staff.getId().equals(cashierID)){
                staff.setHired(false);
                return true;
            }
        }
        return false;
    }

}
