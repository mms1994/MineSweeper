package main;

import main.impl.MineSweeperImpl;

import java.util.logging.Logger;

/**
 * Created by Michał Spirała
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        String start = "*...\n..*.\n....";
        LOGGER.info("\n" + start);
        String result = null;
        try {
            mineSweeper.setMineField(start);
            result = mineSweeper.getHintField();
        } catch (IllegalArgumentException e) {
            LOGGER.warning("Error");
        }
        LOGGER.info("\n" + result);
    }
}
