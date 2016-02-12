package org.usfirst.frc.team3863.kotlin.commands

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class DirectDriveArmCommand(val direction: Boolean) : BaseCommand("Drive Arm Command | Direct") {

    internal var done = false

    init {
        requires(arm)
    }

    override fun initialize() {
        arm.armMotor.enable()
        arm.armMotor.enableControl()
    }

    override fun execute() {
        if (direction) {
            if (arm.encVal() > 0.1) {
                arm.lower(0.5)
            }
        } else {
            if (arm.encVal() < 1.4) {
                arm.raise(0.5)
            }
        }
        done = true
    }

    override fun isFinished(): Boolean {
        return !(oi.leftJoyButton3.get() or oi.leftJoyButton5.get())
    }

    override fun end() {
        arm.stopLift()
    }

    fun stopLift() {
        arm.stopLift()
    }

    override fun interrupted() {
    }

}