package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class MapCreator implements  MapCreatorInterface {
    private final Random random;
    private final MapParameters mapParam;

    public MapCreator(Random random, MapParameters mapParameters) {
        this.random = random;
        this.mapParam = mapParameters;
    }

    public String[][] createMap() {
        int width = mapParam.getWidth();
        int height = mapParam.getHeight();
        int hillAmount = mapParam.getHillAmount();
        int hillArea = mapParam.getHillArea();
        int pitAmount = mapParam.getPitAmount();
        int waterAmount = mapParam.getWaterAmount();
        int mineralAmount = mapParam.getMineralAmount();



        String[][] map = new String[width][height];
        basicMapGenerator(map, width, height);
        for (int i = hillAmount; i > 0; i--) {
            hillCreator(map, hillArea, width,height);
        }
        mineralCreator(map,width,height, mineralAmount);

        for(int j = 0; j < pitAmount; j ++){
            createPits(map, width, height,pitAmount);
        }
        for(int i = 0; i < waterAmount; i ++){
            createWater(map, width, height, waterAmount);
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
            if (map[i][j].equals("o") && neighborChecker("#", i, j, map)) {
                map[i][j] = "~";
                waterSavedAmount--;
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

    private Boolean neighborChecker(String symbol,int i, int j, String[][] map) {

        if((i < mapParam.getWidth()-1 && i > 0) && (j < mapParam.getHeight()-1 && j >0)) {
            if(map[i][j-1] == symbol || map[i][j+1] == symbol || map[i+1][j] == symbol || map[i-1][j] == symbol){
                return true;
            }
        }
        return  false;
    }
}
