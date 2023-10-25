package com.codecool.marsexploration;

import com.codecool.marsexploration.Creator.MapCreator;
import com.codecool.marsexploration.Writer.Writer;

import java.io.IOException;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        MapCreator mapCreator = new MapCreator();
        System.out.println(random.nextInt(42));
        System.out.println(mapCreator.createMap(10,10,6,6));
         String [][] map = new  String[10][10];
       // Writer writer = new Writer(map);
       // writer.writeMapToTxt();


    }
}
