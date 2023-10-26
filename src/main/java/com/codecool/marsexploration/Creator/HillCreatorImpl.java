package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class HillCreatorImpl implements HillCreator {
    Random random = new Random();
    private  String hillSymbol = Symbols.HILL.getSymbol();
    @Override
    public void HillCreator(String[][] map, int hillArea, int width, int height) {
        int hillAreaSaved = hillArea;
        int randomNumX = random.nextInt(3, width - 5);
        int randomNumY = random.nextInt(3, height - 5);
        map[randomNumX][randomNumY] = hillSymbol;
        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                if (map[i - 1][j + 1] == hillSymbol || map[i - 1][j - 1] == hillSymbol || map[i - 1][j] == hillSymbol) {
                    map[i][j] = hillSymbol;
                    hillAreaSaved--;
                }
                if (hillAreaSaved == 0) {
                    break;
                }
            }
        }

    }
    }
