package org.usfirst.frc.team3863.commands.drive;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/25/2016.
 * Project: 2016Robot
 */
public class ArmBreakCommand extends BaseCommand {

    public final boolean state;

    public ArmBreakCommand(boolean enabled) {
        state = enabled;
    }

    @Override
    protected void initialize() {
        arm.armMotor.enableBrakeMode(state);
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
