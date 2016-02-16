package org.usfirst.frc.team3863.commands.endeffector;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class TimedIntakeCommand extends BaseCommand {

    public final boolean direction;
    public final double power;

    public TimedIntakeCommand(double timeout, double power, boolean reversed) {
        super(timeout);
        requires(intake);
        this.power = Math.abs(power);
        this.direction = reversed;
    }

    @Override
    protected void initialize() {
        intake.expell(direction ? power : -power);
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
