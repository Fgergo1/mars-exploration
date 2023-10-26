package com.codecool.marsexploration.Creator;

import java.util.Random;

public class MapCreator {

    private Random random = new Random();

    public String[][] createMap(int height, int width, int hillAmount, int mineralAmount, int pilAmount, int waterAmount) {
        String[][] map = new String[width][height];
        basicMapGenerator(map, width, height);

        for (int i = 0; i < hillAmount; i++) {
            hillCreator(map, width, height,hillAmount);
        }
        for(int j = 0; j < pilAmount; j ++){
            createPits(map,width,height,pilAmount);
        }
        for(int i = 0; i < waterAmount; i ++){
            createWater(map,width,height,waterAmount);
        }


        return map;
    }

    private void basicMapGenerator(String[][] map, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = "o";
            }
        }
    }

    private void hillCreator(String[][] map, int width, int height , int hillAmount) {
        int hillPlaced = 0;
        while (hillPlaced < hillAmount ){
            int randomNumX = random.nextInt( width);
            int randomNumY = random.nextInt( height);
            if(map[randomNumX][randomNumY].equals("o")){
                map[randomNumX][randomNumY] = "^";
                hillPlaced ++;
            }
        }
    }
    private void createPits(String[][] map, int width, int height, int pilAmount) {
        int pitsPlaced = 0;

        while (pitsPlaced < pilAmount) {
            int randomNumX = random.nextInt(width - 1);
            int randomNumY = random.nextInt(height - 4);
            boolean canPlacePit = true;

            for (int i = randomNumX; i < randomNumX + 2; i++) {
                for (int j = randomNumY; j < randomNumY + 5; j++) {
                    if (!map[i][j].equals("o")) {
                        canPlacePit = false;
                        break;
                    }
                }
                if (!canPlacePit) {
                    break;
                }
            }
            if (canPlacePit) {
                for (int i = randomNumX; i < randomNumX + 2; i++) {
                    for (int j = randomNumY; j < randomNumY + 5; j++) {
                        map[i][j] = "#";
                    }
                }
                pitsPlaced++;
            }
        }
    }
    private void createWater(String[][] map, int width, int height, int waterAmount) {
        int waterSavedAmount = waterAmount;

        while (waterSavedAmount > 0) {
            int i = random.nextInt(width);
            int j = random.nextInt(height);
            if (map[i][j].equals("o") && neighborChecker("#", i, j, map, "~")) {
                map[i][j] = "~";
                waterSavedAmount--;
            }
        }
    }
    private boolean neighborChecker(String symbol, int i, int j, String[][] map, String treasure) {
        int width = map.length;
        int height = map[0].length;

        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                int neighborX = i + x;
                int neighborY = j + y;

                if (neighborX >= 0 && neighborX < width && neighborY >= 0 && neighborY < height) {
                    if (map[neighborX][neighborY].equals(symbol) && !map[i][j].equals(treasure)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
