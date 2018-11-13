package com.ctm.simulator.toyrobot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RobotTest {

    @Test
    public void shouldSetRobotsPosition() throws Exception {
        Position newPosition = new Position(3, 5, Direction.SOUTH);
        assertThat(new Robot().set(newPosition), is(newPosition));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfRobotsNewPositionisNull() throws Exception {
        assertThat(new Robot().set(null), is(nullValue()));
    }

    @Test
    public void shouldMoveRobot() throws Exception {

        Robot robot = new Robot();
        robot.set(new Position(3, 5, Direction.WEST));

        Position newPosition = robot.move();
        assertThat(newPosition.getX(), is(2));
        assertThat(newPosition.getY(), is(5));
        assertThat(newPosition.getDirection(), is(Direction.WEST));
    }

    @Test
    public void shouldTurnRobotToTheLeft() throws Exception {

        Robot robot = new Robot();
        robot.set(new Position(3, 5, Direction.WEST));

        Position newPosition = robot.turnLeft();
        assertThat(newPosition.getDirection(), is(Direction.SOUTH));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenTurningRobotToTheLeftIfRobotHasNoCurrentDirection()
            throws Exception {
        Robot robot = new Robot();
        robot.set(new Position(3, 5, null));

        Position newPosition = robot.turnLeft();
        assertThat(newPosition.getDirection(), is(nullValue()));
    }

    @Test
    public void shouldTurnRobotToTheRight() throws Exception {
        Robot robot = new Robot();
        robot.set(new Position(3, 5, Direction.WEST));

        Position newPosition = robot.turnRight();
        assertThat(newPosition.getDirection(), is(Direction.NORTH));
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenTurningRobotToTheRightIfRobotHasNoCurrentDirection()
            throws Exception {
        Robot robot = new Robot();
        robot.set(new Position(3, 5, null));

        Position newPosition = robot.turnRight();
        assertThat(newPosition.getDirection(), is(nullValue()));
    }

}
