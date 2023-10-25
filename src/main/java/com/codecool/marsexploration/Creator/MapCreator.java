package com.codecool.marsexploration.Creator;

import java.util.Random;

public class MapCreator {

    private Random random = new Random();

    public String[][] createMap(int height, int width, int hillAmount, int mineralAmount, int pilAmount, int waterAmount) {
        String[][] map = new String[width][height];
        basicMapGenerator(map, width, height);

        for (int i = 0; i < hillAmount; i++) {
            hillCreator(map, width, height);
        }

        mineralCreator(map, width, height, mineralAmount);
        pilCreator(map, width, height, pilAmount);
        waterCreator(map, width, height, waterAmount);

        return map;
    }

    private void basicMapGenerator(String[][] map, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = "o";
            }
        }
    }

    private void hillCreator(String[][] map, int width, int height) {
        int randomNumX = random.nextInt(0, width);
        int randomNumY = random.nextInt(0, height);

        map[randomNumX][randomNumY] = "^";
    }

    private void mineralCreator(String[][] map, int width, int height, int mineralAmount) {
        for (int i = 0; i < mineralAmount; i++) {
            int randomNumX = random.nextInt(0, width);
            int randomNumY = random.nextInt(0, height);

            if (map[randomNumX][randomNumY].equals("o")) {
                map[randomNumX][randomNumY] = "*";
            }
        }
    }

    private void pilCreator(String[][] map, int width, int height, int pilAmount) {
        for (int i = 0; i < pilAmount; i++) {
            int randomNumX = random.nextInt(0, width);
            int randomNumY = random.nextInt(0, height);

            if (map[randomNumX][randomNumY].equals("o")) {
                map[randomNumX][randomNumY] = "#";
            }
        }
    }

    private void waterCreator(String[][] map, int width, int height, int waterAmount) {
        for (int i = 0; i < waterAmount; i++) {
            int randomNumX = random.nextInt(0, width);
            int randomNumY = random.nextInt(0, height);

            if (map[randomNumX][randomNumY].equals("o")) {
                map[randomNumX][randomNumY] = "~";
            }
        }
    }
}
