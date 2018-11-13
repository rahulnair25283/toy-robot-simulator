package com.ctm.simulator.toyrobot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PositionTest {

    @Test
    public void shouldMoveToNextPosition() throws Exception {
        Position nextPosition = new Position(0, 0, Direction.NORTH).next();

        assertThat(nextPosition.getX(), is(0));
        assertThat(nextPosition.getY(), is(1));
        assertThat(nextPosition.getDirection(), is(Direction.NORTH));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenMovingToNextPositionIfDirectionOfCurrentPositionIsNull()
            throws Exception {
        Position nextPosition = new Position(0, 0, null).next();

        assertThat(nextPosition.getX(), is(0));
        assertThat(nextPosition.getY(), is(0));
        assertThat(nextPosition.getDirection(), is(Direction.NORTH));
    }
}
