package com.ctm.simulator.toyrobot;

import java.util.HashMap;
import java.util.Map;

public enum Direction {

    NORTH(1), EAST(2), SOUTH(3), WEST(4);
    
    private static Map<Integer, Direction> map = new HashMap<>();

    static {
        for (Direction directionEnum : Direction.values()) {
            map.put(directionEnum.directionId, directionEnum);
        }
    }
    
    public static Direction valueOf(int directionNum) {
        return map.get(directionNum);
    }
    
    private int directionId;
    
    private Direction(int directionId) {
        this.directionId = directionId;
    }
    
    public Direction left() {
        if (this.directionId == 1) {
            return Direction.WEST;
        }
        
        return Direction.valueOf(directionId - 1);
    }
    
    public Direction right() {
        if (this.directionId == 4) {
            return Direction.NORTH;
        }
        
        return Direction.valueOf(directionId + 1);
    }
}
