package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class PitCreatorImpl implements PitCreator{
    Random random = new Random();
    private String groundSymbol = Symbols.GROUND.getSymbol();
    private  String pitsSymbol = Symbols.PIT.getSymbol();
    @Override
    public void createPits(String[][] map, int width, int height, int pilAmount) {
        int pitsPlaced = 0;

        while (pitsPlaced < pilAmount) {
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
