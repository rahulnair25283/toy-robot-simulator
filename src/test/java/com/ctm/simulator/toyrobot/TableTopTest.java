package com.ctm.simulator.toyrobot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TableTopTest {

    @Test
    public void shouldReturnTrueIfARobotsGivenPositionIsValid() {
        TableTop tableTop = new TableTop(5, 5);

        assertThat(tableTop.isValid(new Position(3, 1, Direction.NORTH)), is(true));
        assertThat(tableTop.isValid(new Position(1, 1, Direction.NORTH)), is(true));
        assertThat(tableTop.isValid(new Position(5, 5, Direction.NORTH)), is(true));
    }

    @Test
    public void shouldReturnFalseIfARobotsGivenPositionIsNotValid() {
        TableTop tableTop = new TableTop(5, 5);

        assertThat(tableTop.isValid(new Position(-1, 1, Direction.NORTH)), is(false));
        assertThat(tableTop.isValid(new Position(6, 0, Direction.NORTH)), is(false));
        assertThat(tableTop.isValid(new Position(5, 7, Direction.NORTH)), is(false));
        assertThat(tableTop.isValid(new Position(5, -3, Direction.NORTH)), is(false));
    }
}
