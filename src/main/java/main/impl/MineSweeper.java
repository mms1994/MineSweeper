package main.impl;

/**
 * Created by Michał Spirała
 */
public interface MineSweeper {
    void setMineField(String mineField) throws IllegalArgumentException;
    String getHintField() throws IllegalArgumentException;
}
