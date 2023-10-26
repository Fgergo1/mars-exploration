package com.codecool.marsexploration.Ui;

import com.codecool.marsexploration.Creator.MapCreator;
import com.codecool.marsexploration.Input.MapParameters;
import com.codecool.marsexploration.Writer.Writer;

import java.io.IOException;

public class MapUi {
    private final MapParameters mapParameters;
    private final MapCreator mapCreator;
    private final Writer writer;

    public MapUi(MapParameters mapParameters, MapCreator mapCreator, Writer writer) {
        this.mapParameters = mapParameters;
        this.mapCreator = mapCreator;
        this.writer = writer;
    }

    public void run() throws IOException {
        mapParameters.getParametersFromInput();
        mapCreator.createMap();
        writer.writeMapToTxt();
    }
}
