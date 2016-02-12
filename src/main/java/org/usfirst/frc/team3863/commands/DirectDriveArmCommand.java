package org.usfirst.frc.team3863.commands;

/**
 * Created by Joshua Freedman on 2/10/2016.
 * Project: 2016Robot
 */
public class DirectDriveArmCommand extends BaseCommand {

    boolean done = false;
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
            if (arm.encVal() > 0.1) {
                arm.lower(0.5);
            }
        } else {
            if (arm.encVal() < 1.4) {
                arm.raise(0.5);
            }
        }
        done = true;
    }

    @Override
    protected boolean isFinished() {
        System.out.println(oi.btnArmLower.get() || oi.btnArmRaise.get());
        return !(oi.btnArmLower.get() || oi.btnArmRaise.get());
    }

    @Override
    protected void end() {
        arm.stopLift();
    }

    public void stopLift() {
        arm.stopLift();
    }

    @Override
    protected void interrupted() {
    }
}
