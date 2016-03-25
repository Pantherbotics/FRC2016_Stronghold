package org.usfirst.frc.team3863.commands.arm;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/24/2016.
 * Project: 2016Robot
 */
public class ZeroArmCommand extends CommandGroup {

    public ZeroArmCommand() {
        super("Zero Arm Command");
        addSequential(new LowerArm());
        addSequential(new Calibrate());
    }

    private static class LowerArm extends BaseCommand {
        private double speed = 0.5;

        public LowerArm() {
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

    private static class Calibrate extends BaseCommand {

        public Calibrate() {
            requires(arm);
        }

        @Override
        protected void initialize() {
            arm.raise(0.20);
        }

        @Override
        protected void execute() {

        }

        @Override
        protected boolean isFinished() {
            return !arm.armMotor.isRevLimitSwitchClosed();
        }

        @Override
        protected void end() {
            arm.reZero();
            arm.stopLift();
        }

        @Override
        protected void interrupted() {

        }
    }
}
