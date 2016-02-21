package org.usfirst.frc.team3863.commands.arm;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Joshua Freedman on 2/10/2016.
 * Project: 2016Robot
 */
public class DirectDriveArmCommand extends BaseCommand {

    boolean direction = false;

    public DirectDriveArmCommand(boolean direction) {
        requires(arm);
        this.direction = direction;
    }

    @Override
    protected void initialize() {
        arm.armMotor.enable();
        arm.armMotor.enableControl();
    }

    @Override
    protected void execute() {
        if (direction) {
            arm.lower(0.5);
        } else {
            arm.raise(0.5);
        }
    }

    @Override
    protected boolean isFinished() {
        return !(oi.btnArmLower.get() || oi.btnArmRaise.get());
    }

    @Override
    protected void end() {
        arm.stopLift();
    }

    @Override
    protected void interrupted() {
    }
}
