package com.codecool.marsexploration.Creator;

import java.util.Random;

public class MapCreator implements  MapCreatorInterface {
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

=======

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
