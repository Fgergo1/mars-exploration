package com.codecool.marsexploration.Creator;

import java.util.Random;

public class MapCreator {

    private MapCreator mapCreator;
    private Random random;

    public String[][] createMap(int height,int width, int pitArea, int hillArea) {
        String [][] map = new String[width][height];
        int hillAmount
        int piStarterArea = pitArea
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (pitArea == piStarterArea ) {

                }
                map[i][j] = "w";
            }
        }
        return map;
    }
}
