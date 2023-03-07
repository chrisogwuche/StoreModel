package com.decagon.entity;

import com.decagon.enums.Gender;
import com.decagon.enums.Role;

public class Staffs extends Users{
    private String qualification;

    private Role role;
    private  boolean hired;

    public Staffs(){}
    public Staffs( String id,String name, int age, Gender gender, String qualification,Role role, boolean hired){
        super(id,name,age,gender);
        this.role = role;
        this.qualification = qualification;
        this.hired = hired;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isHired() {
        return hired;
    }

    public void setHired(boolean hired) {
        this.hired = hired;
    }
    @Override
    public String toString() {
        return "Staffs{" +
                "id=" + getId()+
                ", name=" + getName() +
                ", age=" + getAge() +
                ", Gender=" + getGender() +
                ", qualification='" + qualification + '\'' +
                ", role=" + role +
                ", hired=" + hired +
                '}';
    }

}
