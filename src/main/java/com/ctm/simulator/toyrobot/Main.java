package com.ctm.simulator.toyrobot;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner io = null;
        try {
            io = new Scanner(System.in);
            App app = new App(new TableTop(5, 5), new Robot());

            System.out.println("--------------------");
            System.out.println("Hi, I am a toy robot");
            System.out.println("--------------------");
            System.out.println("");
            System.out.println("You can interact with me using the following commands");
            System.out.println("PLACE X,Y,NORTH or SOUTH or EAST or WEST");
            System.out.println("MOVE");
            System.out.println("LEFT");
            System.out.println("RIGHT");
            System.out.println("REPORT");
            System.out.println("--------------------");
            System.out.print("Give me a command or type QUIT to make me sad! :( : ");

            String commandString = null;
            boolean isFirstCommand = true;
            boolean quit = false;

            while (!quit) {
                commandString = io.nextLine().toUpperCase();

                if (isFirstCommand && !commandString.contains("PLACE")) {
                    System.out.println("lol nah! Use the PLACE command first");
                    continue;
                }

                isFirstCommand = false;

                if ("QUIT".equals(commandString)) {
                    System.out.println("I sad, ciao!");
                    quit = true;
                } else {
                    CommandValidator.validate(commandString);
                    System.out.println(app.execute(commandString));
                }
            }
        } finally {
            if (io != null) {
                io.close();
            }
        }
    }
}
