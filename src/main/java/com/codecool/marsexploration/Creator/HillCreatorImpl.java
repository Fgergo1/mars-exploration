package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class HillCreatorImpl implements LandMarks {


    Random random;
    private  String hillSymbol = Symbols.HILL.getSymbol();

    public HillCreatorImpl(Random random) {
        this.random = random;
    }
    @Override
    public void createLandmark(String[][] map, MapParameters mapParameters, int width, int height) {
        int hillAmount = mapParameters.getHillAmount();
        for (int z = 0; z < hillAmount; z++) {

            int hillArea = mapParameters.getHillArea();
            int randomNumX = random.nextInt(3, width - 5);
            int randomNumY = random.nextInt(3, height - 5);
            map[randomNumX][randomNumY] = hillSymbol;
            for (int i = 1; i < width - 1; i++) {
                for (int j = 1; j < height - 1; j++) {
                    if (map[i - 1][j + 1] == hillSymbol || map[i - 1][j - 1] == hillSymbol || map[i - 1][j] == hillSymbol) {
                        map[i][j] = hillSymbol;
                        hillArea--;
                    }
                    if (hillArea == 0) {
                        break;
                    }
                }
            }

        }

    }
}
