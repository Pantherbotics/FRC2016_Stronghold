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
        System.out.println("CENTERTRUE");
        shooter.setCenteringSolenoid(true);
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
        System.out.println("CENTERFALSE");
        shooter.setCenteringSolenoid(false);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
