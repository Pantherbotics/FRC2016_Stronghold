package org.usfirst.frc.team3863.commands;

/**
 * Created by Fox on 3/24/2016.
 * Project: 2016Robot
 */
public class TestCommand extends BaseCommand {

    public TestCommand() {
        super("Test Command");
        requires(shooter);
        setTimeout(2);
    }

    @Override
    protected void initialize() {
        byte[] array = {1,2,3,4};
        leds.getPort().write(array, 4);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        end();
    }
}
