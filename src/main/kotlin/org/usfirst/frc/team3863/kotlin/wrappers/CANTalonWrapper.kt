package org.usfirst.frc.team3863.kotlin.wrappers

import edu.wpi.first.wpilibj.CANTalon

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class CANTalonWrapper(i0: Int, i1: Int, invert: Boolean = false) {

    private var m0: CANTalon = CANTalon(i0)
    private var m1: CANTalon = CANTalon(i1)

    init {
        m0.inverted = invert
        m1.inverted = invert
    }

    fun set(outputValue: Double) {
        m0.set(outputValue)
        m1.set(outputValue)
    }

    var inverted: Boolean
        get() = m0.inverted && m1.inverted
        set(isInverted) {
            m0.inverted = isInverted
            m1.inverted = isInverted
        }

    operator fun set(outputValue: Double, thisValueDoesNotDoAnything: Byte) {
        m0.set(outputValue, thisValueDoesNotDoAnything)
        m1.set(outputValue, thisValueDoesNotDoAnything)
    }

    fun reset() {
        m0.reset()
        m1.reset()
    }

    val isEnabled: Boolean
        get() = m0.isEnabled || m1.isEnabled


    val error: Double
        get() = (m0.error + m1.error) / 2

    fun setSetpoint(setpoint: Double) {
        m0.setpoint = setpoint
        m1.setpoint = setpoint
    }

    fun reverseOutput(flip: Boolean) {
        m0.reverseOutput(flip)
        m1.reverseOutput(flip)
    }

    fun reverseSensor(flip: Boolean) {
        m0.reverseSensor(flip)
        m1.reverseSensor(flip)
    }

    fun get(): Double {
        return (m0.get() + m1.get()) / 2
    }

    var encPosition: Int
        get() = (m0.encPosition + m1.encPosition) / 2
        set(newPosition) {
            m0.encPosition = newPosition
            m1.encPosition = newPosition
        }

    val encVelocity: Int
        get() = (m0.encVelocity + m1.encVelocity) / 2

    fun isSensorPresent(feedbackDevice: CANTalon.FeedbackDevice): CANTalon.FeedbackDeviceStatus {
        return if (m0.isSensorPresent(feedbackDevice).value == 1 || m1.isSensorPresent(feedbackDevice).value == 1) CANTalon.FeedbackDeviceStatus.FeedbackStatusPresent else CANTalon.FeedbackDeviceStatus.FeedbackStatusUnknown
    }


    fun configEncoderCodesPerRev(codesPerRev: Int) {
        m0.configEncoderCodesPerRev(codesPerRev)
        m1.configEncoderCodesPerRev(codesPerRev)
    }


    val temperature: Double
        get() = (m0.temperature + m1.temperature) / 2


    val outputCurrent: Double
        get() = (m0.outputCurrent + m1.outputCurrent) / 2


    val busVoltage: Double
        get() = (m0.busVoltage + m1.busVoltage) / 2


    val outputVoltage: Double
        get() = (m0.outputVoltage + m1.outputVoltage) / 2


    var position: Double
        get() = (m0.position + m1.position) / 2
        set(pos) {
            m0.position = pos
            m1.position = pos
        }


    val speed: Double
        get() = (m0.speed + m1.speed) / 2


    val controlMode: CANTalon.TalonControlMode
        get() = CANTalon.TalonControlMode.valueOf(m0.controlMode.value and m1.controlMode.value)


    fun setControlMode(mode: Int) {
        m0.setControlMode(mode)
        m1.setControlMode(mode)
    }


    fun changeControlMode(controlMode: CANTalon.TalonControlMode) {
        m0.changeControlMode(controlMode)
        m1.changeControlMode(controlMode)
    }


    fun setFeedbackDevice(device: CANTalon.FeedbackDevice) {
        m0.setFeedbackDevice(device)
        m1.setFeedbackDevice(device)
    }


    fun enable() {
        m0.enable()
        m1.enable()
    }


    fun enableControl() {
        m0.enableControl()
        m1.enableControl()
    }


    val isControlEnabled: Boolean
        get() = m0.isControlEnabled || m1.isControlEnabled


    fun disableControl() {
        m0.disableControl()
        m1.disableControl()
    }


    var p: Double
        get() = (m0.p + m1.p) / 2
        set(p) {
            m0.p = p
            m1.p = p
        }


    var i: Double
        get() = (m0.i + m1.i) / 2
        set(i) {
            m0.i = i
            m1.i = i
        }


    var d: Double
        get() = (m0.d + m1.d) / 2
        set(d) {
            m0.d = d
            m1.d = d
        }


    var f: Double
        get() = (m0.f + m1.f) / 2
        set(f) {
            m0.f = f
            m1.f = f
        }


    fun setIZone(izone: Int) {
        m0.setIZone(izone)
        m1.setIZone(izone)
    }


    val iZone: Double
        get() = (m0.iZone + m1.iZone) / 2


    fun setPID(p: Double, i: Double, d: Double, f: Double, izone: Int, closeLoopRampRate: Double, profile: Int) {
        m0.setPID(p, i, d, f, izone, closeLoopRampRate, profile)
        m1.setPID(p, i, d, f, izone, closeLoopRampRate, profile)
    }


    fun setPID(p: Double, i: Double, d: Double) {
        m0.setPID(p, i, d)
        m1.setPID(p, i, d)
    }


    fun disable() {
        m0.disable()
        m1.disable()
    }


    fun enableBrakeMode(brake: Boolean) {
        m0.enableBrakeMode(brake)
        m1.enableBrakeMode(brake)
    }

    fun stopMotors() {
        m0.set(0.0)
        m1.set(0.0)
    }
}
