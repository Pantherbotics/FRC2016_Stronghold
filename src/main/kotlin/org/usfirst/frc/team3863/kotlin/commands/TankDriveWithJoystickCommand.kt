package org.usfirst.frc.team3863.kotlin.commands


/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class TankDriveWithJoystickCommand : BaseCommand("Tank Drive Command | Joystick") {

    init {
        requires(driveTrain)
    }

    override fun initialize() {
        driveTrain.enableMotors()
    }

    override fun execute() {
        if (!oi.leftJoyButton2.get()) {
            driveTrain.tankDrive(oi.rightJoystick, oi.leftJoystick)
        } else {
            driveTrain.tankDrive(-oi.leftJoystick.twist, oi.leftJoystick.twist)
        }
    }

    override fun isFinished(): Boolean {
        return false
    }

    override fun end() {
        driveTrain.stopMotors()
    }

    override fun interrupted() {
        end()
    }

}
