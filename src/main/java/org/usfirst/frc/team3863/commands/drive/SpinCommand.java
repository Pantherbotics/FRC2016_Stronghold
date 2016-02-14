package org.usfirst.frc.team3863.commands.drive;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by robotics on 2/8/2016.
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
