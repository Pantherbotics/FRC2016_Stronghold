package org.usfirst.frc.team3863.commands;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */

public class EnableDriveCommand extends BaseCommand {

    public EnableDriveCommand() {
        super("Enable Drive Command");
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        driveTrain.enableMotors();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
