package com.ctm.simulator.toyrobot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Position {

    @Getter
    @Setter
    private int x;

    @Getter
    @Setter
    private int y;

    @Getter
    @Setter
    private Direction direction;

    public Position next() throws Exception {
        if (this.direction == null) {
            throw new Exception("Robot's direction cannot be null");
        }

        Position newPosition = new Position(this.x, this.y, this.getDirection());

        switch (direction) {
        case NORTH:
            newPosition.setY(newPosition.getY() + 1);
            break;
        case EAST:
            newPosition.setX(newPosition.getX() + 1);
            break;
        case SOUTH:
            newPosition.setY(newPosition.getY() - 1);
            break;
        case WEST:
            newPosition.setX(newPosition.getX() - 1);
            break;
        }

        return newPosition;
    }
}
