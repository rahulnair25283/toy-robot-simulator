package com.ctm.simulator.toyrobot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Robot {

    @Getter
    @Setter
    private Position position;

    public Position set(Position newPosition) throws Exception {
        if (newPosition == null) {
            throw new Exception("Robot's new position cannot be null");
        }

        this.position = newPosition;
        return this.position;
    }

    public Position move() throws Exception {
        return set(this.position.next());
    }

    public Position turnLeft() throws Exception {
        if (this.position.getDirection() == null) {
            throw new Exception("Robot's direction cannot be null");
        }

        this.position.setDirection(this.position.getDirection().left());
        return this.position;
    }

    public Position turnRight() throws Exception {
        if (this.position.getDirection() == null) {
            throw new Exception("Robot's direction cannot be null");
        }

        this.position.setDirection(this.position.getDirection().right());
        return this.position;
    }

}
