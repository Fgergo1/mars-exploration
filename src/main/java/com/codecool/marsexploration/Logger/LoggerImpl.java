package com.codecool.marsexploration.Logger;

import java.time.LocalDate;

public class LoggerImpl implements Logger{

    @Override
    public void logInfo(String info) {
        System.out.println(LocalDate.now() + "INFO: " + info);
    }

    @Override
    public void logError(String error) {
        System.out.println(LocalDate.now() + "ERROR:  " + error);
    }
}
