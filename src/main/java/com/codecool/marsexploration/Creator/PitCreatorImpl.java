package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class PitCreatorImpl implements LandMarks{

    private final Random random;
    private final String groundSymbol = Symbols.GROUND.getSymbol();
    private final String pitsSymbol = Symbols.PIT.getSymbol();
    public PitCreatorImpl(Random random) {
        this.random = random;
    }

    @Override
    public void createLandmark(String[][] map, MapParameters mapParameters, int width, int height) {
        int pitsPlaced = 0;

        while (pitsPlaced < mapParameters.getPitAmount()) {
            int randomNumX = random.nextInt(width - 1);
            int randomNumY = random.nextInt(height - 4);
            boolean canPlacePit = true;

            for (int i = randomNumX; i < randomNumX + 2; i++) {
                for (int j = randomNumY; j < randomNumY + 5; j++) {
                    if (!map[i][j].equals(groundSymbol)) {
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
                        map[i][j] = pitsSymbol;
                    }
                }
                pitsPlaced++;
            }
        }
    }
}
