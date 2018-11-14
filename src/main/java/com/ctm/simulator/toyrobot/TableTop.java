package com.ctm.simulator.toyrobot;

import com.google.common.collect.Range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TableTop {
    
    private static final int FIRST_INDEX = 1;

    @Getter
    @Setter
    private int rows;

    @Getter
    @Setter
    private int columns;

    /**
     * Checks if a given position is valid on the table top
     * 
     * @param position
     *            the position to be validated
     * @return true if the position is valid and false otherwise
     */
    public boolean isValid(Position position) {
        return Range.closed(FIRST_INDEX, this.rows).contains(position.getX())
                && Range.closed(FIRST_INDEX, this.columns).contains(position.getY());
    }
}
