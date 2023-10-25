package com.codecool.marsexploration.Creator;

import java.util.Random;

public class MapCreator implements  MapCreatorInterface {


    private final Random random;

    public MapCreator(Random random) {
        this.random = random;
    }

    public String[][] createMap(int height, int width, int pitArea, int hillArea, int hillAmount, int mineralAmount) {
        String[][] map = new String[width][height];
        basicMapGenerator(map, width, height);
        for (int i = hillAmount; i > 0; i--) {
            hillCreator(map,hillArea,width,height);
        }
        mineralCreator(map,width,height,mineralAmount);

        return map;
    }

    private void basicMapGenerator(String[][] map, int width, int height) {
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                map[i][j] = "o";
            }
        }
    }


    private void hillCreator(String[][] map, int hillArea, int width, int height) {
        int hillAreaSaved = hillArea;
        int randomNumX = random.nextInt(3,width-5);
        int randomNumY = random.nextInt(3,height-5);
        map[randomNumX][randomNumY] = "^";


            for (int i = 1; i < width - 1; i++) {
                for (int j = 1; j < height - 1; j++) {
                    if(map[i-1][j+1] == "^" || map[i-1][j-1] == "^" || map[i-1][j] == "^") {
                        map[i][j] = "^";
                        hillAreaSaved--;
                    }if (hillAreaSaved == 0) {
                        break;
                    }
                }
            }

    }

    private void mineralCreator(String[][] map,int width, int height, int mineralAmount) {
        int savedMineralAmount = mineralAmount;

        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                if(neighborChecker("^",i,j,map)&& random.nextBoolean()) {
                    map[i][j] = "*";
                    savedMineralAmount--;
                }if (savedMineralAmount == 0) {
                    break;
                }
            }
        }
    }

    private Boolean neighborChecker(String symbol,int i, int j, String[][] map){
        if(map[i][j-1] == symbol && map[i][j] != symbol) {
            return true;
        } else if (map[i][j+1] == symbol && map[i][j] != symbol) {
            return true;
        }
        else if (map[i-1][j] == symbol && map[i][j] != symbol) {
            return true;
        }
        return false;
    }


}
