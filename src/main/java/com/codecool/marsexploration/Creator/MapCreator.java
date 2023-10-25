package com.codecool.marsexploration.Creator;

import java.util.Random;

public class MapCreator {

    private MapCreator mapCreator;
    private Random random = new Random(3);
    private int piStarterArea;

    public String[][] createMap(int height,int width, int pitArea, int hillArea) {
        String [][] map = new String[width][height];
        int piStarterArea = pitArea;
        int hillStarterArea = hillArea;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int randomLandmark= random.nextInt(3);
                if(randomLandmark == 1 &&
                        piStarterArea == pitArea ||
                        piStarterArea % 6 == 0){
                    map[i][j] = ">";
                    piStarterArea --;
                } else if ( randomLandmark == 1 &&
                        piStarterArea > 0 &&
                        (map[i-1][j+1] == ">" || map[i-1][j -1] == ">")) {
                    map[i][j] = ">";
                    piStarterArea --;
                }else if((randomLandmark == 2 && hillStarterArea == hillArea) ||
                        (hillArea % 6 == 0  && map[i-1][j-1] == ">")) {
                    map[i][j] = "-";
                    hillStarterArea--;
                }else if (randomLandmark == 2 && hillStarterArea > 0 &&
                        i > 0 && j > 0 &&
                        (map[i-1][j] == "-" && map[i][j-1] == "-")){
                    map[i][j] = "-";
                    hillStarterArea --;
                } else if (randomLandmark == 0 || randomLandmark == 3) {
                    map[i][j] = ".";
                }
            }
        }
        return map;
    }
}
