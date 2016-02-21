package org.usfirst.frc.team3863.commands.arm;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by robotics on 2/9/2016.
 */
public class ElevateArmToPosCommand extends BaseCommand {

    public static final double GAIN = 4.0;

    public final double pos;
    public final double tolerance;

    public ElevateArmToPosCommand(double pos) {
        this(pos, 0.05);
    }

    public ElevateArmToPosCommand(double pos, double tolerance){
        this(pos, tolerance, -1);
    }

    public ElevateArmToPosCommand(double pos, double tolerance, double timeout) {
        super("Elevate Arm to Position");
        requires(arm);
        this.pos = pos;
        this.tolerance = tolerance;
        if (timeout > 0) setTimeout(timeout);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        arm.raise((pos - arm.encVal()) * GAIN);
    }

    @Override
    protected boolean isFinished() {
        return isTimedOut() || (Math.abs(pos - arm.encVal()) < 0.05);
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
