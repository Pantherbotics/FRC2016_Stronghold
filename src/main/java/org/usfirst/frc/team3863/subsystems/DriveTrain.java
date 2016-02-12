package org.usfirst.frc.team3863.subsystems;

import org.usfirst.frc.team3863.RobotMap;
import org.usfirst.frc.team3863.commands.TankDriveWithJoystickCommand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3863.wrappers.CANTalonWrapper;

/**
 * <hr>
 * <h1>Drive Train Subsystem</h1>
 * <p>The subsystem that handles any and all code related to interfacing with the drive train.</p>
 *
 * @see edu.wpi.first.wpilibj.command.Subsystem
 */
public class DriveTrain extends Subsystem {

    public CANTalonWrapper leftMotors = new CANTalonWrapper(RobotMap.LEFT_DRIVE_MOTOR_0, RobotMap.LEFT_DRIVE_MOTOR_1);
    public CANTalonWrapper rightMotors = new CANTalonWrapper(RobotMap.RIGHT_DRIVE_MOTOR_0, RobotMap.RIGHT_DRIVE_MOTOR_1, true);


    public DriveTrain() {
        super("Drive Train Subsystem");
    }

    public void log() {
        SmartDashboard.putNumber("Left Position", leftMotors.getEncPosition());
        SmartDashboard.putNumber("Right Position", rightMotors.getPosition());
        SmartDashboard.putNumber("Left Speed", leftMotors.getSpeed());
        SmartDashboard.putNumber("Right Speed", rightMotors.getSpeed());
    }

    /**
     * Tank style driving for the DriveTrain.
     *
     * @param left  - Value for left motors
     * @param right - Value for right motors
     */
    public void tankDrive(double left, double right) {
        leftMotors.set(left);
        rightMotors.set(right);
    }

    public void tankDrive(Joystick left, Joystick right) {
        this.tankDrive(left.getY(), right.getY());
    }

    /**
     * Stops all motors in the drive train
     */
    public void stopMotors() {
        leftMotors.stopMotors();
        rightMotors.stopMotors();
    }

    public void enableMotors() {
        leftMotors.enable();
        leftMotors.enableControl();
        rightMotors.enable();
        rightMotors.enableControl();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDriveWithJoystickCommand());
    }

}
