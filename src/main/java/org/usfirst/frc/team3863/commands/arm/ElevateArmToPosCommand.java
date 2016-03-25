package org.usfirst.frc.team3863.commands.arm;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by robotics on 2/9/2016.
 */
@SuppressWarnings("SameParameterValue")
public class ElevateArmToPosCommand extends BaseCommand {

    public final double gain;

    public final double pos;
    public final double tolerance;

    public ElevateArmToPosCommand(double pos) {
        this(pos, 0.03);
    }

    public ElevateArmToPosCommand(double pos, double tolerance){
        this(pos, tolerance, -1);
    }

    public ElevateArmToPosCommand(double pos, double tolerance, double timeout){
        this(pos, tolerance, timeout, 4.0);
    }

    public ElevateArmToPosCommand(double pos, double tolerance, double timeout, double gain) {
        this(pos, tolerance, timeout, gain, false);
    }

    public ElevateArmToPosCommand(double pos, double tolerance, double timeout, double gain, boolean brake) {
        super("Elevate Arm to Position");
        this.gain = gain;
        requires(arm);
        this.pos = pos;
        this.tolerance = tolerance;
        arm.armMotor.enableBrakeMode(brake);
        if (timeout > 0) setTimeout(timeout);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        arm.raise((pos - arm.encVal()) * gain);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || (Math.abs(pos - arm.encVal()) < tolerance);
    }

    @Override
    protected void end() {
        arm.stopLift();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
