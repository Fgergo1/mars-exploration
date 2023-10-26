package com.codecool.marsexploration.Input;

import com.codecool.marsexploration.Logger.Logger;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Scanner;

public class MapParameters {

    private final Scanner scanner;
    private final Logger logger;

    private int height;
    private int width;
    private int hillArea;
    private int pitArea;

    private int pitAmount;
    private int hillAmount;
    private int mineralAmount;
    private int waterAmount;

    public MapParameters(Scanner scanner, Logger logger) {
        this.scanner = scanner;
        this.logger = logger;

    }

    public int getMineralAmount() {
        return mineralAmount;
    }
    public int getWaterAmount() {
        return waterAmount;
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
    public int getPitAmount() {
        return pitAmount;
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

        logger.logInfo("Please add the amount of the waters!");
        this.waterAmount = scanner.nextInt();

        logger.logInfo("Please add the size of the pits!");
        this.pitArea = scanner.nextInt();

        logger.logInfo("Please add the amount of the pits!");
        this.pitAmount = scanner.nextInt();
    }

}
