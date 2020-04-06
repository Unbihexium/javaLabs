package com.company.lab4.university;

import java.util.Date;

public class Olympiad implements Event {

    //Определите  класс  Olympiad,  реализующий  интерфейс  Event.
    //Содержит  приватные  поля  – дата  и  название   города,  а  так  же  место  (целое  число),  
    //которое  занял  студент  на  олимпиаде.
    //Реализовать  методы  доступа  (геттеры  и  сеттеры)  для  приватных  полей.

    private Date date;
    private String city;

    private Student student;

    private int place;


    public Olympiad(Date date, String city, Student student, int place) {
        this.date = date;
        this.city = city;
        this.student = student;
        this.place = place;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
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
