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

        switch (direction) {
        case NORTH:
            this.y += 1;
            break;
        case EAST:
            this.x += 1;
            break;
        case SOUTH:
            this.y -= 1;
            break;
        case WEST:
            this.x -= 1;
            break;
        }

        return this;
    }
}
