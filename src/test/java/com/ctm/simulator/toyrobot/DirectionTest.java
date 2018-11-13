package com.ctm.simulator.toyrobot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DirectionTest {

    @Test
    public void shouldGetLeftOfCurrentDirection() {
        assertThat(Direction.NORTH.left(), is(Direction.WEST));
        assertThat(Direction.EAST.left(), is(Direction.NORTH));
        assertThat(Direction.SOUTH.left(), is(Direction.EAST));
        assertThat(Direction.WEST.left(), is(Direction.SOUTH));
    }
    
    @Test
    public void shouldGetRightOfCurrentDirection() {
        assertThat(Direction.NORTH.right(), is(Direction.EAST));
        assertThat(Direction.EAST.right(), is(Direction.SOUTH));
        assertThat(Direction.SOUTH.right(), is(Direction.WEST));
        assertThat(Direction.WEST.right(), is(Direction.NORTH));
    }

}
