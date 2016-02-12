package org.usfirst.frc.team3863.kotlin.subsystems

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import org.usfirst.frc.team3863.RobotMap
import org.usfirst.frc.team3863.commands.TankDriveWithJoystickCommand
import org.usfirst.frc.team3863.wrappers.CANTalonWrapper

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class DriveTrain : Subsystem("Drive Subsystem") {

    var leftMotors = CANTalonWrapper(RobotMap.LEFT_DRIVE_MOTOR_0, RobotMap.LEFT_DRIVE_MOTOR_1)
    var rightMotors = CANTalonWrapper(RobotMap.RIGHT_DRIVE_MOTOR_0, RobotMap.RIGHT_DRIVE_MOTOR_1, true)

    fun log() {
        SmartDashboard.putNumber("Left Position", leftMotors.encPosition.toDouble())
        SmartDashboard.putNumber("Right Position", rightMotors.position)
        SmartDashboard.putNumber("Left Speed", leftMotors.speed)
        SmartDashboard.putNumber("Right Speed", rightMotors.speed)
    }

    /**
     * Tank style driving for the DriveTrain.
     * @param left  - Value for left motors
     * *
     * @param right - Value for right motors
     */
    fun tankDrive(left: Double, right: Double) {
        leftMotors.set(left)
        rightMotors.set(right)
    }

    fun tankDrive(left: Joystick, right: Joystick) {
        this.tankDrive(left.y, right.y)
    }

    /**
     * Stops all motors in the drive train
     */
    fun stopMotors() {
        leftMotors.stopMotors()
        rightMotors.stopMotors()
    }

    fun enableMotors() {
        leftMotors.enable()
        leftMotors.enableControl()
        rightMotors.enable()
        rightMotors.enableControl()
    }

    override fun initDefaultCommand() {
        defaultCommand = TankDriveWithJoystickCommand()
    }
}