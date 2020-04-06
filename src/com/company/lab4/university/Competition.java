package com.company.lab4.university;

import java.util.Date;

public class Competition implements Event {

    //Определите  класс  Сompetition,  реализующий  интерфейс  Event.
    //Содержит   приватные   поля   – дата   и   название   города,   а   так   же   название   проекта   и  
    //выигранная  сумма
    //Реализовать  методы  доступа  (геттеры  и  сеттеры)  для  приватных  полей.

    private Date date;
    private String city;

    private Student student;
    private String projectName;
    private int moneyWon;



    public Competition(Date date, String city, Student student, String projectName, int moneyWon) {
        this.date = date;
        this.city = city;
        this.student = student;
        this.projectName = projectName;
        this.moneyWon = moneyWon;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getMoneyWon() {
        return moneyWon;
    }

    public void setMoneyWon(int moneyWon) {
        this.moneyWon = moneyWon;
    }

    @Override
    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public Date getDate() {
        return this.date;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getCity() {
        return this.city;
    }
}
