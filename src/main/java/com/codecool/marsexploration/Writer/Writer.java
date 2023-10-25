package com.codecool.marsexploration.Writer;

import com.codecool.marsexploration.Creator.MapCreator;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private String [][] map;
    private final String filePath = "src/main/resources" + "exploration-4.txt";

    public Writer(String[][] map) {
        this.map = map;
    }


    public void writeMapToTxt () throws IOException {

        FileWriter fileWriter = new FileWriter(filePath);
        for (int i = 0; i < map.length ; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if(map[i][j] == ">"){
                    fileWriter.write(">");
                } else if (map[i][j] == "-") {
                    fileWriter.write("-");
                } else if (map[i][j] == ".") {
                    fileWriter.write('.');
                }else{
                    fileWriter.write(".");
                }

            }
            fileWriter.write(System.lineSeparator());
        }
        fileWriter.close();
    }
}
