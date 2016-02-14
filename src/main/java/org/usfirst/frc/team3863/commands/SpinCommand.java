package org.usfirst.frc.team3863.commands;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public class SpinCommand extends BaseCommand {

    boolean direction;

    public SpinCommand(boolean direction) {
        requires(driveTrain);
        this.direction = direction;
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
