package main.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by Michał Spirała
 */
public class MineSweeperImplTest {
    @Test
    public void shouldBeEqual() {
//        given
        MineSweeperImpl mineSweeper = new MineSweeperImpl();
        String start = "*...\n..*.\n....";
        String expected = "*211\n12*1\n0111";
        mineSweeper.setMineField(start);
//        when
        String result = mineSweeper.getHintField();
//        then
        assertEquals(expected, result);
    }

}