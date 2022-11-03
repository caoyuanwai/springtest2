package com.yuanwai.team.domain;

import com.yuanwai.team.service.Status;

public class Programmer extends Employee{
    private int memberId;
    private Status status = Status.FREE;
    private Equipment equipment;

    public Programmer() {
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString() + "\t\t程序员\t\t" + status +"\t\t\t\t\t" + equipment.getDescription();
    }

    public String getBaseDetails() {
        return memberId + "/" + getId() + "\t\t" + getName() + "\t" + getAge() + "\t\t" + getSalary();
    }

    public String getDetailsForTeam() {
        return  getBaseDetails()+ "\t程序员";
    }
}