package com.codecool.marsexploration;

import com.codecool.marsexploration.Creator.MapCreator;
import com.codecool.marsexploration.Creator.NeighborChecker;
import com.codecool.marsexploration.Creator.NeighborCheckerImpl;
import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Logger.Logger;
import com.codecool.marsexploration.Logger.LoggerImpl;
import com.codecool.marsexploration.Ui.MapUi;
import com.codecool.marsexploration.Writer.Writer;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Logger logger = new LoggerImpl();
        MapParameters mapParameters = new MapParameters(scanner,logger);
        NeighborChecker neighborChecker = new NeighborCheckerImpl(mapParameters);
        MapCreator mapCreator = new MapCreator(random, mapParameters, neighborChecker);
        Writer writer = new Writer(mapCreator);
        MapUi mapUi = new MapUi(mapParameters,mapCreator,writer);
        
        mapUi.run();


    }
}
