package com.codecool.marsexploration.Creator;

import com.codecool.marsexploration.Input.MapParameters;

public class NeighborCheckerImpl implements NeighborChecker{
   private final MapParameters mapParameters;

    public NeighborCheckerImpl(MapParameters mapParameters) {
        this.mapParameters = mapParameters;
    }
    @Override
    public boolean NeighborChecker(String symbol, int i, int j, String[][] map) {
        if((i < mapParameters.getWidth()-1 && i > 0) && (j < mapParameters.getHeight()-1 && j >0)) {
            if(map[i][j-1] == symbol || map[i][j+1] == symbol || map[i+1][j] == symbol || map[i-1][j] == symbol){
                return true;
            }
        }
        return  false;
    }
    }

