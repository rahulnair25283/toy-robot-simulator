package com.ctm.simulator.toyrobot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class TableTop {

    @Getter
    @Setter
    private int rows;
    
    @Getter
    @Setter
    private int columns;
}
