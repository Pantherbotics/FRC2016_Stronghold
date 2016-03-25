package org.usfirst.frc.team3863.commands.arm;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/24/2016.
 * Project: 2016Robot
 */
public class ZeroArmCommand extends BaseCommand {

    private double speed = 0.5;

    public ZeroArmCommand() {
        super("Zero Arm Command");
        requires(arm);
    }

    @Override
    protected void initialize() {
        speed = 0.5;
    }

    @Override
    protected void execute() {
        speed += 0.02;
        arm.lower(speed);
    }

    @Override
    protected boolean isFinished() {
        return arm.armMotor.isRevLimitSwitchClosed();
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
