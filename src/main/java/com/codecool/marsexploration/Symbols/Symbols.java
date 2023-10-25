package com.codecool.marsexploration.Symbols;

public enum Symbols {

    HILL("^"),
    PIT("#"),
    MINERALS("*"),
    WATER("~");

    private final String symbol;
    Symbols(String symbol) {
        this.symbol = symbol;
    }
}
