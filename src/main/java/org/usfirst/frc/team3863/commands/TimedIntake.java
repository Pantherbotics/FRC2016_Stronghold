package org.usfirst.frc.team3863.commands;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class TimedIntake extends BaseCommand {

    public final boolean direction;

    public TimedIntake(double timeout, boolean reversed) {
        super(timeout);
        requires(intake);
        this.direction = reversed;
    }

    @Override
    protected void initialize() {
        intake.pickupMotor.enable();
        intake.pickupMotor.enableControl();
        intake.expell(direction ? 1 : -1);
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
        intake.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
