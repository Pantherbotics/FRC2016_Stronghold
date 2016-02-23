package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 2/20/2016.
 * Project: 2016Robot
 */
public class AutoTransmissionCommand extends BaseCommand {

    public static AutoTransmissionCommand instance;

    public boolean fastMode = false;
    public boolean state = false;

    public AutoTransmissionCommand() {
        super("Auto Transmission Command");
        instance = this;
        requires(transmission);
    }

    @Override
    protected void initialize() {
        System.out.println("Starting Transmission");
    }

    @Override
    protected void execute() {
        if (fastMode) {
            double a = driveTrain.leftMotors.getOutputValue(), b = driveTrain.rightMotors.getOutputValue();
            if (Math.abs(a) + Math.abs(b) > 0.5) {
                if (Math.abs(a - b) > 0.75 || a * b < 0) {
                    state = false;
                } else if (Math.abs(a - b) < 0.25) {
                    state = true;
                }
            }
            transmission.getDriveTrainSolenoid().set(state ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
        } else {
            transmission.getDriveTrainSolenoid().set(DoubleSolenoid.Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {
        end();
    }

    public static class Switch extends BaseCommand {

        public final boolean state;

        public Switch(boolean state) {
            this.state = state;
        }

        @Override
        protected void initialize() {
            instance.fastMode = state;
        }

        @Override
        protected void execute() {

        }

        @Override
        protected boolean isFinished() {
            return true;
        }

        @Override
        protected void end() {

        }

        @Override
        protected void interrupted() {

        }
    }
}
