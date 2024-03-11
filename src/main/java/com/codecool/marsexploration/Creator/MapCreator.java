package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Symbols.Symbols;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapCreator implements  MapCreatorInterface {
    private final MapParameters mapParam;
    private final List<LandMarks> creators;

    public MapCreator(Random random, MapParameters mapParameters, NeighborChecker neighborChecker) {
        this.mapParam = mapParameters;
        this.creators = new ArrayList<>(List.of(new HillCreatorImpl(random), new PitCreatorImpl(random), new MineralCreatorImpl(neighborChecker,random), new WaterCreatorImpl(random, neighborChecker)));
    }

    public String[][] createMap() {
        int width = mapParam.getWidth();
        int height = mapParam.getHeight();
        String[][] map = new String[width][height];
        basicMapGenerator(map, width, height);

        for (LandMarks creator : creators) {
            creator.createLandmark(map,mapParam,width,height);
        }
        return map;
    }

    private void basicMapGenerator(String[][] map, int width, int height) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = Symbols.GROUND.getSymbol();
            }
        }
    }

}
