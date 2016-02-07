package org.usfirst.frc.team3863.subsystems;

import org.usfirst.frc.team3863.Robot;
import org.usfirst.frc.team3863.RobotMap;
import org.usfirst.frc.team3863.commands.TankDriveWithJoystick;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

//    private final AnalogGyro gyro;

    public DriveTrain() {
        super("Drive Train");
    }

    public void log() {
        SmartDashboard.putNumber("Left Position", Robot.oi.leftMotors.getEncPosition());
        SmartDashboard.putNumber("Right Position", Robot.oi.rightMotors.getPosition());
        SmartDashboard.putNumber("Left Speed", Robot.oi.leftMotors.getSpeed());
        SmartDashboard.putNumber("Right Speed", Robot.oi.rightMotors.getSpeed());
    }

    /**
     * Tank style driving for the DriveTrain.
     *
     * @param left  - Value for left motors
     * @param right - Value for right motors
     */
    public void tankDrive(double left, double right) {
        log();
        Robot.oi.leftMotors.set(left);
        Robot.oi.rightMotors.set(right);
    }

    public void tankDrive(Joystick left, Joystick right) {
        this.tankDrive(left.getY(), right.getY());
    }

    /**
     * Stops all motors in the drive train
     */
    public void stopMotors() {
        Robot.oi.leftMotors.stopMotors();
        Robot.oi.rightMotors.stopMotors();
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub
//        setDefaultCommand(new TankDriveWithJoystick());
    }

}
