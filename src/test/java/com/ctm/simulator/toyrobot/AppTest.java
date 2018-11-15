package com.ctm.simulator.toyrobot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AppTest {

    @Test
    public void shouldSuccessfullyExecutePlaceCommand() throws Exception {
        App app = new App(new TableTop(5, 5), new Robot());
        assertThat(app.execute("PLACE 1,2,NORTH"), is("I am now at x1 y2 facing NORTH"));
    }

    @Test
    public void shouldFailToExecutePlaceCommandIfProvidedPositionIsInvalid() throws Exception {
        App app = new App(new TableTop(5, 5), new Robot());
        assertThat(app.execute("PLACE -1,2,NORTH"),
                is("I cant move to the new position, I will fall off the table top"));
    }

    @Test
    public void shouldSuccessfulltExecuteMoveCommand() throws Exception {
        App app = new App(new TableTop(5, 5), new Robot());

        app.execute("PLACE 1,2,NORTH");

        assertThat(app.execute("MOVE"), is("I am now at x1 y3 facing NORTH"));
    }

    @Test
    public void shouldFailToExecuteMoveCommandIfTheNextPositionIsInvalid() throws Exception {
        App app = new App(new TableTop(5, 5), new Robot());

        app.execute("PLACE 1,4,NORTH");

        assertThat(app.execute("MOVE"),
                is("I cant move to the new position, I will fall off the table top"));
    }

    @Test
    public void shouldSuccessfulltExecuteLeftCommand() throws Exception {
        App app = new App(new TableTop(5, 5), new Robot());

        app.execute("PLACE 0,4,NORTH");

        assertThat(app.execute("LEFT"), is("I am now at x0 y4 facing WEST"));
    }

    @Test
    public void shouldSuccessfullyExecuteRightCommand() throws Exception {
        App app = new App(new TableTop(5, 5), new Robot());

        app.execute("PLACE 0,4,NORTH");

        assertThat(app.execute("RIGHT"), is("I am now at x0 y4 facing EAST"));
    }

}
