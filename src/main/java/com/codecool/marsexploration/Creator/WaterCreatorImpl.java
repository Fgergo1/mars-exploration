package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class WaterCreatorImpl  implements WaterCreator{
   private Random random = new Random();
    private NeighborChecker neighborChecker;
    private  final String waterSymbol = Symbols.WATER.getSymbol();
    private final  String groundSymbol = Symbols.GROUND.getSymbol();
    private final String pitsSymbol = Symbols.PIT.getSymbol();
    @Override
    public void createWater(String[][] map, int width, int height, int waterAmount) {
        int waterSavedAmount = waterAmount;


        while (waterSavedAmount > 0) {
            int i = random.nextInt(width);
            int j = random.nextInt(height);
            if (map[i][j].equals(groundSymbol) && neighborChecker.NeighborChecker(pitsSymbol, i, j, map)) {
                map[i][j] = waterSymbol;
                waterSavedAmount--;
            }
        }
    }
}
