package com.codecool.marsexploration.Writer;

import com.codecool.marsexploration.Creator.MapCreator;

import java.io.FileWriter;
import java.io.IOException;

    public class Writer {


        private final MapCreator mapCreator;
        private final String filePath = "src/main/resources" + "exploration-4.txt";

        public Writer(MapCreator mapCreator) {
            this.mapCreator = mapCreator;
        }


        public void writeMapToTxt() throws IOException {
            String[][] map = mapCreator.createMap();
            FileWriter fileWriter = new FileWriter(filePath);
            for (int i = 1; i < map[i].length - 1; i++) {
                for (int j = 1; j < map[j].length - 1; j++) {

                    fileWriter.write(map[i][j]);
                }
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.close();
        }
    }


