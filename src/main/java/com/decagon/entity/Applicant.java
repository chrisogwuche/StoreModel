package com.decagon.entity;

import com.decagon.enums.Gender;

public class Applicant extends Users {
    private int yearsOfExperience;
    private String qualification;
    public Applicant(){}


    public Applicant(String id, String name, int age, Gender gender, int yearsOfExperience, String qualification){
        super(id,name,age,gender);
        this.yearsOfExperience = yearsOfExperience;
        this.qualification = qualification;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Applicant{" +
                "super=" + super.toString() +
                "yearsOfExperience=" + yearsOfExperience +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
