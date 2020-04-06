package com.company.lab4.university;

import java.util.Date;

public class Conference implements Event {

    // Определите  класс  Сonference,  реализующий  интерфейс  Event.
    //Содержит   приватные   поля   – дата   и   название   города,   а   так   же   название   доклада  
    //(статьи),  с  которым  (которой)  студент    выступал  на  конференции.
    //Реализовать  методы  доступа  (геттеры  и  сеттеры)  для  приватных  полей.

    private Date date;
    private String city;

    private Student student;
    private String title;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Conference(Date date, String city, Student student, String title) {
        this.date = date;
        this.city = city;
        this.student = student;
        this.title = title;
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
