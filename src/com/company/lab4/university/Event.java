package com.company.lab4.university;

import java.util.Date;

public interface Event {
    // Создайте   интерфейс   Event – мероприятия,   в   котором   участвовал   студент,  
    //описывающий  методы:
    //- геттеры  и  сеттеры  для  даты  проведения  мероприятия  (работают  с  экземплярами  
    //класса  java.util.Date)
    //- геттеры  и  сеттеры  для  названия  города,  в  котором  проводилось  мероприятие

    void setDate(Date date);

    Date getDate();

    void setCity(String city);

    String getCity();

}
