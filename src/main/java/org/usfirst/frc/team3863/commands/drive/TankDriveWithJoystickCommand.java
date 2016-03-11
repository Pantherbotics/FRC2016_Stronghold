package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.CANTalon;
import org.usfirst.frc.team3863.commands.BaseCommand;

public class TankDriveWithJoystickCommand extends BaseCommand {

    public TankDriveWithJoystickCommand() {
        // TODO Auto-generated constructor stub
        requires(driveTrain);
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub
        driveTrain.enableMotors();
        driveTrain.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }

    @Override
    protected void execute() {
        // TODO Auto-generated method stub
        if (!oi.rightJoyButton2.get()) {
            driveTrain.tankDrive(oi.leftJoystick, oi.rightJoystick);
        } else {
            driveTrain.tankDrive(-oi.rightJoystick.getTwist(), oi.rightJoystick.getTwist());
        }
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end() {
        // TODO Auto-generated method stub
        driveTrain.stopMotors();
    }

    @Override
    protected void interrupted() {
        // TODO Auto-generated method stub
        end();
    }

}
