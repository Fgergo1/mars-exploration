package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Symbols.Symbols;

import java.util.Random;

public class MineralCreatorImpl implements MineralCreator {
    Random random = new Random();
    NeighborChecker neighborChecker;
    private String mineralSymbol = Symbols.MINERALS.getSymbol();
    private  String hillSymbol = Symbols.HILL.getSymbol();
    @Override
    public void MineralCreator(String[][] map, int width, int height, int mineralAmount) {
        int savedMineralAmount = mineralAmount;

        for (int i = 1; i < width - 1; i++) {
            for (int j = 1; j < height - 1; j++) {
                if(neighborChecker.NeighborChecker(hillSymbol,i,j,map)&& random.nextBoolean()) {
                    map[i][j] = mineralSymbol;
                    savedMineralAmount--;
                }if (savedMineralAmount == 0) {
                    break;
                }
            }
        }
    }
}
