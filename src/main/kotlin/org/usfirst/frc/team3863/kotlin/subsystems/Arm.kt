package org.usfirst.frc.team3863.kotlin.subsystems

import edu.wpi.first.wpilibj.AnalogInput
import edu.wpi.first.wpilibj.CANTalon
import edu.wpi.first.wpilibj.command.Subsystem
import org.usfirst.frc.team3863.RobotMap

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class Arm : Subsystem("Arm Subsystem") {

    var armMotor = CANTalon(RobotMap.ARM_MOTOR)
    var endEffectorMoto = CANTalon(RobotMap.END_EFFECTOR_MOTOR)

    var magEncoder = AnalogInput(0)

    protected override fun initDefaultCommand() {

    }

    fun encVal(): Double {
        return magEncoder.voltage
    }

    fun lower(v: Double) {
        armMotor.set(-v)
    }

    fun raise(v: Double) {
        armMotor.set(v)
    }

    fun stopLift() {
        armMotor.set(0.0)
    }

}