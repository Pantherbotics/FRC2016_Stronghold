package org.usfirst.frc.team3863.commands;

/**
 * Created by Robotics on 2/10/2016.
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
        done = false;
        System.err.println("INIT");
    }

    @Override
    protected void execute() {
        if (direction) {
            System.out.println("L: " + arm.encVal());
            if (arm.encVal() > 0.1) {
                arm.lower(0.5);
            }
        } else {
            System.out.println("R: " + arm.encVal());
            if (arm.encVal() < 1.4) {
                arm.raise(0.5);
            }
        }
            done = true;
}

    @Override
    protected boolean isFinished() {
        return done;
    }

    @Override
    protected void end() {
        System.err.println("END");
//        arm.stopLift();
    }

    public void stopLift() {
        arm.stopLift();
    }

    @Override
    protected void interrupted() {
        System.err.println("COMPLETED");
        done = true;
    }
}
