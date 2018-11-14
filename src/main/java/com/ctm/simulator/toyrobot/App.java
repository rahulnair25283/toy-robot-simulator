package com.ctm.simulator.toyrobot;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class App {

    private TableTop tableTop;
    private Robot robot;

    public String execute(String commandString) throws Exception {

        String[] parts = commandString.split(" ");
        Command command = Command.valueOf(parts[0]);

        switch (command) {
        case PLACE:
            String[] parameters = parts[1].split(",");
            Position position = new Position(Integer.parseInt(parameters[0]),
                    Integer.parseInt(parameters[1]), Direction.valueOf(parameters[2]));

            if (!tableTop.isValid(position)) {
                return "I cant move to the new position, I will fall off the table top";

            }

            robot.set(position);
            break;
        case MOVE:
            Position nextPosition = robot.getPosition().next();
            if (!tableTop.isValid(nextPosition)) {
                return "I cant move to the new position, I will fall off the table top";
            }

            robot.set(nextPosition);
            break;
        case LEFT:
            robot.turnLeft();
            break;
        case RIGHT:
            robot.turnRight();
            break;
        case REPORT:
            break;
        }

        return report();
    }

    private String report() throws Exception {
        if (robot.getPosition() == null) {
            System.out.println("I have panicked, I will quit now. Find the reason below.");
            throw new Exception(
                    "I haven't even gotten onto the table top yet! Use the PLACE command to set me on the table top");
        }

        return "I am now at x" + robot.getPosition().getX() + " y" + robot.getPosition().getY()
                + " facing " + robot.getPosition().getDirection().toString();
    }

}
