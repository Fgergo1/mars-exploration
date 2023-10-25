package com.codecool.marsexploration.Landmarks;

import com.codecool.marsexploration.Symbols.Symbols;
import com.codecool.marsexploration.data.Coordinate;

public class Pit extends Placeble {
    private final Symbols symbols  = Symbols.PIT;
    private Coordinate coordinate;

    public Pit(Coordinate coordinate) {
        super(coordinate);
    }


}
