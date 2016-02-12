package org.usfirst.frc.team3863.kotlin.subsystems

import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc.team3863.RobotMap

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class Pneumatics : Subsystem("Pneumatics Subsystem") {
    var compressor: Compressor
        internal set
    var driveTrainSolenoid = DoubleSolenoid(RobotMap.DRIVE_TRAIN_SOLENOID_0, RobotMap.DRIVE_TRAIN_SOLENOID_1)
        internal set
    var armSolenoid = DoubleSolenoid(RobotMap.ARM_SOLENOID_0, RobotMap.ARM_SOLENOID_1)
        internal set
    var endEffectorSolenoid = DoubleSolenoid(RobotMap.END_EFFECTOR_SOLENOID_0, RobotMap.END_EFFECTOR_SOLENOID_1)
        internal set

    init {
        compressor = Compressor(RobotMap.COMPRESSOR)
        stopCompressor()
    }

    fun fireSolenoid(solenoid: DoubleSolenoid, direction: DoubleSolenoid.Value) {
        if (solenoid.get() != direction) {
            solenoid.set(direction)
        }
    }

    fun toggleSolenoid(solenoid: DoubleSolenoid) {
        if (solenoid.get() == DoubleSolenoid.Value.kForward) {
            solenoid.set(DoubleSolenoid.Value.kReverse)
        } else {
            solenoid.set(DoubleSolenoid.Value.kForward)
        }
    }

    private fun stopCompressor() {
        compressor.stop()
    }

    private fun startCompressor() {
        compressor.start()
    }

    override fun initDefaultCommand() {

    }

}
