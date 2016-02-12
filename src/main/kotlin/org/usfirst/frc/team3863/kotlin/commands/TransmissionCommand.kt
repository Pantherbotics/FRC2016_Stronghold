package org.usfirst.frc.team3863.kotlin.commands

import edu.wpi.first.wpilibj.DoubleSolenoid

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class TransmissionCommand(val enable: Boolean) : BaseCommand("Transmission Command") {

    init {
        requires(pneumatics)
    }

    override fun initialize() {

    }

    override fun execute() {
        if (enable) {
            pneumatics.fireSolenoid(pneumatics.driveTrainSolenoid, DoubleSolenoid.Value.kForward)
        } else {
            pneumatics.fireSolenoid(pneumatics.driveTrainSolenoid, DoubleSolenoid.Value.kReverse)
        }
    }

    override fun isFinished(): Boolean {
        return true
    }

    override fun end() {

    }

    override fun interrupted() {

    }
}
