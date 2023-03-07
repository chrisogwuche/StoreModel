package com.decagon.service;

import com.decagon.entity.Applicant;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ManagerService {

    void setCheckRequirement(@NotNull List<Applicant> applicantList);
    boolean setHireCashier(String cashierID);
    boolean setSackCashier(String cashierID);
}
