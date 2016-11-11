package main.impl;

import org.apache.commons.lang3.StringUtils;

import java.util.logging.Logger;

/**
 * Created by Michał Spirała
 */
public class MineSweeperImpl implements MineSweeper {
    private final static Logger LOGGER = Logger.getLogger(MineSweeperImpl.class.getName());
    private final static String NEW_LINE = "\n";
    private final static String MINE = "*";
    private Integer numberOfLines = 0;
    Integer numberOfElementsInLine = 0;
    private String[][] field = null;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        numberOfLines = StringUtils.countMatches(mineField, NEW_LINE) + 1;
        LOGGER.info(numberOfLines.toString());
        String[] array = mineField.split(NEW_LINE);
        numberOfElementsInLine = array[0].length();
        for (String s : array)
            if (s.length() != numberOfElementsInLine)
                throw new IllegalArgumentException("Not all lines have the same number of elements");
        field = new String[numberOfLines][numberOfElementsInLine];
        for (Integer line = 0; line < numberOfLines; line++)
            for (Integer column = 0; column < numberOfElementsInLine; column++) {
                field[line][column] = String.valueOf(array[line].charAt(column));
            }
    }

    @Override
    public String getHintField() throws IllegalArgumentException {
        if (field == null)
            throw new IllegalArgumentException("Field not initialized");
        String result = "";
        for (Integer line = 0; line < numberOfLines; line++) {
            for (Integer column = 0; column < numberOfElementsInLine; column++)
                switch (field[line][column]) {
                    case MINE:
                        result += MINE;
                        break;
                    default:
                        Integer numberOfMines = 0;
                        if (line - 1 >= 0) {
                            if (column - 1 >= 0 && field[line - 1][column - 1].equals(MINE))
                                numberOfMines++;
                            if (field[line - 1][column].equals(MINE))
                                numberOfMines++;
                            if (column + 1 < numberOfElementsInLine && field[line - 1][column + 1].equals(MINE))
                                numberOfMines++;
                        }
                        if (column - 1 >= 0 && field[line][column - 1].equals(MINE))
                            numberOfMines++;
                        if (column + 1 < numberOfElementsInLine && field[line][column + 1].equals(MINE))
                            numberOfMines++;
                        if (line + 1 < numberOfLines) {
                            if (column - 1 >= 0 && field[line + 1][column - 1].equals(MINE))
                                numberOfMines++;
                            if (field[line + 1][column].equals(MINE))
                                numberOfMines++;
                            if (column + 1 < numberOfElementsInLine && field[line + 1][column + 1].equals(MINE))
                                numberOfMines++;
                        }
                        result += numberOfMines;
                        break;
                }
            result += NEW_LINE;
        }
        result = StringUtils.removeEnd(result, NEW_LINE);
        LOGGER.info("Result: \n" + result);
        return result;
    }
}
