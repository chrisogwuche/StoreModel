package com.decagon.controller;

import com.decagon.entity.*;
import com.decagon.enums.Gender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ManagerControllerTest {
    ManagerController managerController;

    @BeforeEach
    void setUp(){
        managerController = new ManagerController();
    }

    @Test
    void checkReturnWhenRequirementIsMeet(){

        List<Applicant> applicantList = new ArrayList<>();
        Applicant applicant1 =
                new Applicant("1","Daniel Obaba",25, Gender.MALE,3,"BSc");
        applicantList.add(applicant1);
        Assertions.assertEquals("Requirement confirmed", managerController.checkRequirement(applicantList));

    }

    @Test
    void  hireCashierWithCorrectApplicantID(){
        checkReturnWhenRequirementIsMeet();
        String applicantID = "1";
        Assertions.assertEquals("Cashier hired", managerController.hireCashier(applicantID));
    }
    @Test
    void  checkSackCashier(){
        checkReturnWhenRequirementIsMeet();
        hireCashierWithCorrectApplicantID();
        String cashierID = "10";

        Assertions.assertEquals("Cashier sacked", managerController.sackCashier(cashierID));
    }



}