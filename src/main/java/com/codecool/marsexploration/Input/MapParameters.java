package com.codecool.marsexploration.Input;

import com.codecool.marsexploration.Logger.Logger;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Scanner;

public class MapParameters {

    private Scanner scanner;
    private Logger logger;

    private int height;
    private int width;
    private int hillArea;
    private int pitArea;
    private int hillAmount;
    private int mineralAmount;

    public MapParameters(Scanner scanner, Logger logger) {
        this.scanner = scanner;
        this.logger = logger;

    }

    public int getMineralAmount() {
        return mineralAmount;
    }

    public int getHillAmount() {
        return hillAmount;
    }

    public int getHillArea() {
        return hillArea;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPitArea() {
        return pitArea;
    }


    public void getParameters () {
        logger.logInfo("Please add the map height!");
        this.height = scanner.nextInt();

        logger.logInfo("Please add the map width!");
        this.width = scanner.nextInt();

        logger.logInfo("Please add the size of the hills!");
        this.hillArea = scanner.nextInt();

        logger.logInfo("Please add the amount of the hills!");
        this.hillAmount = scanner.nextInt();

        logger.logInfo("Please add the amount of the minerals!");
        this.mineralAmount = scanner.nextInt();


        logger.logInfo("Please add the size of the pits!");
        this.pitArea = scanner.nextInt();
    }

}
