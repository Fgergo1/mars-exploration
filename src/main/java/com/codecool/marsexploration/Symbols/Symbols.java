package com.codecool.marsexploration.Symbols;

public enum Symbols {

    GROUND("o"),
    HILL("^"),
    PIT("#"),
    MINERALS("*"),
    WATER("~");

    private final String symbol;
    Symbols(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
