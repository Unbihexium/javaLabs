package com.company.lab4.university;

public class Student {
    //Создайте   публичный   класс   Student   – студента   некоторой   специальности  
    //некоторого   университета.   Класс   не   хранит   явным   образом   информацию   о  
    //специальности,  номере  группы\потока,  предметах,  университете.
    //каждый  студент  характеризуется  именем,  фамилией,  годом  поступления,  
    //уникальным  6-тизначным  номером  зачетной  книжки.
    //конструктор  может  принимать  имя  и  фамилию.  При  этом  номер  зачетной  книжки 0

    private String firstname, surname, patronymic;

    private int admissionYear;

    private int recordBookNumber;

    public Student(String firstname, String surname, String patronymic, int admissionYear) {
        this.firstname = firstname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.admissionYear = admissionYear;
        this.recordBookNumber = 0;
    }

    public Student(String firstname, String surname, String patronymic, int admissionYear, int recordBookNumber) {
        this.firstname = firstname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.admissionYear = admissionYear;
        this.recordBookNumber = recordBookNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    public int getRecordBookNumber() {
        return recordBookNumber;
    }

    public void setRecordBookNumber(int recordBookNumber) {
        this.recordBookNumber = recordBookNumber;
    }
}
