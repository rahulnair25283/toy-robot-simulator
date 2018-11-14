package com.ctm.simulator.toyrobot;

public class CommandValidator {

    public static void validate(String commandString) throws Exception {
        String[] parts = commandString.split(" ");
        Command command = null;
        try {
            command = Command.valueOf(parts[0].toUpperCase());
        } catch (Exception e) {
            System.out.println("I have panicked, I will quit now. Find the reason below.");
            throw new Exception("Oops, I dont recognise the command " + commandString);
        }

        if (command == Command.PLACE) {
            if (parts.length < 2) {
                System.out.println("I have panicked, I will quit now. Find the reason below.");
                throw new Exception(
                        "Oops, the PLACE command should be accompanied by the X and Y indices as well as the direction");
            }

            String[] params = parts[1].split(",");
            try {
                Integer.parseInt(params[0]);
                Integer.parseInt(params[1]);
                Direction.valueOf(params[2]);
            } catch (Exception e) {
                System.out.println("I have panicked, I will quit now. Find the reason below.");
                throw new Exception("Well, you have messed up the PLACE command, haven't you?");
            }
        }
    }
}
