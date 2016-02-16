package org.usfirst.frc.team3863.commands.arm;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by robotics on 2/9/2016.
 */
public class ElevateArmToPosCommand extends BaseCommand {

    public static final double GAIN = 4.0;

    public double pos;

    public ElevateArmToPosCommand(double pos) {
        super("Elevate Arm to Position");
        requires(arm);
        this.pos = pos;
    }

    public ElevateArmToPosCommand(double pos, double timeout){
        this(pos);
        setTimeout(timeout);
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
