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
    ArrayList<String> logMessages = new ArrayList<>();

    public Logger(Class aClass) {
        this.aClass = aClass;
    }

    public void log(String tag, String msg){
        logMessages.add("[" + LocalDateTime.now().format(dateFormat) + "] at " + aClass.getName() + " - " + tag + ": " + msg);
        System.out.println(logMessages.get(logMessages.size() - 1));
    }
}
