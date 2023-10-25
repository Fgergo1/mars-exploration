package com.codecool.marsexploration;

import com.codecool.marsexploration.Writer.Writer;

import java.io.IOException;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        System.out.println(random.nextInt(42));
         int [][] map = new  int[10][10];
        Writer writer = new Writer(map);

        writer.writeMapToTxt();


    }
}
