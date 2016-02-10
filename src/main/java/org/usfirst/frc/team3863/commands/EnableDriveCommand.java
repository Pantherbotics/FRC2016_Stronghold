package org.usfirst.frc.team3863.commands;

/**
 * Created by robotics on 2/9/2016.
 */
public class EnableDriveCommand extends BaseCommand {
    @Override
    protected void initialize() {
        requires(driveTrain);
    }

    @Override
    protected void execute() {
        driveTrain.enableMotors();
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
