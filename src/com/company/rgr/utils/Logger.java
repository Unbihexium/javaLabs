package com.company.rgr.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class Logger {

    Class aClass;
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
    static ArrayList<String> logMessages = new ArrayList<>();

    private Logger(Class aClass){
        this.aClass = aClass;
    }

    public static Logger getLogger(Class aClass){
        return new Logger(aClass);
    }

    public void log(String msg){
        logMessages.add("[" + LocalDateTime.now().format(dateFormat) + "] at " + aClass.getName() + ": " + msg);
        System.out.println(logMessages.get(logMessages.size() - 1));
    }
}
