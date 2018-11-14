package com.ctm.simulator.toyrobot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandValidatorTest {

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfCommandIsInvalid() throws Exception {
        String commandString = "hello";
        CommandValidator.validate(commandString);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfPlaceCommandDoesNotHaveParameters() throws Exception {
        String commandString = "place";
        CommandValidator.validate(commandString);
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionIfTheParametersToThePlaceCommandAreInvalid() throws Exception {
        String commandString = "place 2,1,lol";
        CommandValidator.validate(commandString);
    }

}
