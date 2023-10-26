package com.codecool.marsexploration;

import com.codecool.marsexploration.Creator.MapCreator;
import com.codecool.marsexploration.Writer.Writer;

import java.io.IOException;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
  
MapCreator mapCreator = new MapCreator(random);
        System.out.println(random.nextInt(42));


        Writer writer = new Writer(mapCreator.createMap(20,20,2,10,2,4));

        writer.writeMapToTxt();


    }
}
