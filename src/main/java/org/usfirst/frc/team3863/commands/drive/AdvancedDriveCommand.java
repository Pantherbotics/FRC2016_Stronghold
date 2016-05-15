package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/24/2016.
 * Project: 2016Robot
 */
public class AdvancedDriveCommand extends BaseCommand {

    public static AdvancedDriveCommand instance;

    public boolean fastMode = false;
    public boolean state = false;

    public static AdvancedDriveCommand getInstance() {
        if (instance == null) instance = new AdvancedDriveCommand();
        return instance;
    }

    public AdvancedDriveCommand() {
        super("Auto Transmission Command");
        requires(transmission);
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        System.out.println("Starting Advanced Drive");
        driveTrain.enableMotors();
        driveTrain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }

    @Override
    protected void execute() {
        double l, r;
        int mode;

//        if (oi.joyButtonArcadeMode.get()) {
//            mode = 1;
//            l = oi.rightJoystick.getTwist() - oi.rightJoystick.getY();
//            r = -oi.rightJoystick.getTwist() - oi.rightJoystick.getY();
//        } else if (oi.joyButtonTurnMode.get()) {
//            mode = 2;
//            l = oi.leftJoystick.getRawAxis(3);
//            r = -oi.leftJoystick.getRawAxis(3);
//        } else {
            mode = 0;
            l = -oi.leftJoystick.getY();
            r = -oi.rightJoystick.getY();
//        }

        if (fastMode) {

            if (l * r + 0.01 < 0 || mode == 2) {
                state = false;
            } else {
                if (Math.max(Math.abs(l), Math.abs(r)) < 0.5) {
                    state = false;
                    l *= 2;
                    r *= 2;
                } else if (Math.abs(l) + Math.abs(r) > 0.5) {
                    if (Math.abs(l - r) > 0.75) {
                        state = false;
                    } else if (Math.abs(l - r) < 0.25) {
                        state = true;
                    }
                }

            }
            transmission.getDriveTrainSolenoid().set(state ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
        } else {
            transmission.getDriveTrainSolenoid().set(DoubleSolenoid.Value.kReverse);
        }

        driveTrain.tankDrive(l, r);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        driveTrain.stopMotors();
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
            byte[] array = {4, 1, 6, (byte) (state ? 20 : 10)};
            leds.getPort().write(array, 4);
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
