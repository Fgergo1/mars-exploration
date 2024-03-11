package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class WaterCreatorImpl  implements LandMarks{

    private final Random random;
    private final NeighborChecker neighborChecker;
    private  final String waterSymbol = Symbols.WATER.getSymbol();
    private final  String groundSymbol = Symbols.GROUND.getSymbol();
    private final String pitsSymbol = Symbols.PIT.getSymbol();
    public WaterCreatorImpl(Random random, NeighborChecker neighborChecker) {
        this.random = random;
        this.neighborChecker = neighborChecker;
    }
    @Override
    public void createLandmark(String[][] map, MapParameters mapParameters, int width, int height) {
        int waterSavedAmount = mapParameters.getWaterAmount();


        while (waterSavedAmount > 0) {
            int i = random.nextInt(width);
            int j = random.nextInt(height);
            if (map[i][j].equals(groundSymbol) && neighborChecker.neighborChecker(pitsSymbol, i, j, map)) {
                map[i][j] = waterSymbol;
                waterSavedAmount--;
            }
        }
    }


}
