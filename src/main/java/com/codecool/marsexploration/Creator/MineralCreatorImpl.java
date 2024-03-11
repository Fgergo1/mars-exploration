package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class MineralCreatorImpl implements LandMarks {
   private final Random random;
   private final NeighborChecker neighborChecker;
    private final String mineralSymbol = Symbols.MINERALS.getSymbol();
    private final String hillSymbol = Symbols.HILL.getSymbol();
    public MineralCreatorImpl(NeighborChecker neighborChecker, Random random) {
        this.neighborChecker = neighborChecker;
        this.random = random;
    }
    @Override
    public void createLandmark(String[][] map, MapParameters mapParameters, int width, int height) {
        int savedMineralAmount = mapParameters.getMineralAmount();

        for (int z = 0; z < savedMineralAmount; z++) {

            for (int i = 1; i < width - 1; i++) {
                for (int j = 1; j < height - 1; j++) {
                    if (neighborChecker.neighborChecker(hillSymbol, i, j, map) && random.nextBoolean()) {
                        map[i][j] = mineralSymbol;
                        savedMineralAmount--;
                    }
                    if (savedMineralAmount == 0) {
                        break;
                    }
                }
            }
        }
    }

}
