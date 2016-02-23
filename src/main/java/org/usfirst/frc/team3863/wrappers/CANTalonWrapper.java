package org.usfirst.frc.team3863.wrappers;

import edu.wpi.first.wpilibj.CANTalon;

/**
 * <hr>
 * <h1>CANTalonWrapper</h1>
 * <p>A class that links, via software, two motors together.</p>
 */
public class CANTalonWrapper {

    /**
     * <hr>
     * <h1>Inner CANTalon reference</h1>
     * <p>These motors should only be accessable from with the CANTalonWrapper class.</p>
     */
    private CANTalon m0, m1;
    double value = 0;

    /**
     * <hr>
     * <h1>CANTalonWrapper Constructor</h1>
     * <p>Ports for each motor.</p>
     */
    public CANTalonWrapper(int i0, int i1) {
        m0 = new CANTalon(i0);
        m1 = new CANTalon(i1);
    }

    public double getOutputValue() {
        return value;
    }

    /**
     * <hr>
     * <h1>CANTalonWrapper Constructor</h1>
     * <p>Ports for each motor, and a boolean for if they should be inverted by default.</p>
     */
    public CANTalonWrapper(int i0, int i1, boolean invert) {
        m0 = new CANTalon(i0);
        m1 = new CANTalon(i1);
        setInverted(invert);
    }

    public void set(double outputValue) {
        m0.set(outputValue);
        m1.set(outputValue);
        this.value = outputValue;
    }

    public void setInverted(boolean isInverted) {
        m0.setInverted(isInverted);
        m1.setInverted(isInverted);
    }

    public boolean getInverted() {
        return m0.getInverted() && m1.getInverted();
    }

    public void set(double outputValue, byte thisValueDoesNotDoAnything) {
        set(outputValue);
    }

    public void reset() {
        m0.reset();
        m1.reset();
        this.value = 0;
    }


    public boolean isEnabled() {
        return m0.isEnabled() || m1.isEnabled();
    }


    public double getError() {
        return (m0.getError() + m1.getError()) / 2;
    }

    public void setSetpoint(double setpoint) {
        m0.setSetpoint(setpoint);
        m1.setSetpoint(setpoint);
    }

    public void reverseOutput(boolean flip) {
        m0.reverseOutput(flip);
        m1.reverseOutput(flip);
    }

    public void reverseSensor(boolean flip) {
        m0.reverseSensor(flip);
        m1.reverseSensor(flip);
    }

    public double get() {
        return (m0.get() + m1.get()) / 2;
    }

    public int getEncPosition() {
        return (m0.getEncPosition() + m1.getEncPosition()) / 2;
    }

    public void setEncPosition(int newPosition) {
        m0.setEncPosition(newPosition);
        m1.setEncPosition(newPosition);
    }

    public int getEncVelocity() {
        return (m0.getEncVelocity() + m1.getEncVelocity()) / 2;
    }

    public CANTalon.FeedbackDeviceStatus isSensorPresent(CANTalon.FeedbackDevice feedbackDevice) {
        return (m0.isSensorPresent(feedbackDevice).value == 1 || m1.isSensorPresent(feedbackDevice).value == 1) ? CANTalon.FeedbackDeviceStatus.FeedbackStatusPresent : CANTalon.FeedbackDeviceStatus.FeedbackStatusUnknown;
    }


    public void configEncoderCodesPerRev(int codesPerRev) {
        m0.configEncoderCodesPerRev(codesPerRev);
        m1.configEncoderCodesPerRev(codesPerRev);
    }


    public double getTemperature() {
        return (m0.getTemperature() + m1.getTemperature()) / 2;
    }


    public double getOutputCurrent() {
        return (m0.getOutputCurrent() + m1.getOutputCurrent()) / 2;
    }


    public double getBusVoltage() {
        return (m0.getBusVoltage() + m1.getBusVoltage()) / 2;
    }


    public double getOutputVoltage() {
        return (m0.getOutputVoltage() + m1.getOutputVoltage()) / 2;
    }


    public double getPosition() {
        return (m0.getPosition() + m1.getPosition()) / 2;
    }


    public void setPosition(double pos) {
        m0.setPosition(pos);
        m1.setPosition(pos);
    }


    public double getSpeed() {
        return (m0.getSpeed() + m1.getSpeed()) / 2;
    }


    public CANTalon.TalonControlMode getControlMode() {
        return CANTalon.TalonControlMode.valueOf(m0.getControlMode().value & m1.getControlMode().value);
    }


    public void setControlMode(int mode) {
        m0.setControlMode(mode);
        m1.setControlMode(mode);
    }


    public void changeControlMode(CANTalon.TalonControlMode controlMode) {
        m0.changeControlMode(controlMode);
        m1.changeControlMode(controlMode);
    }


    public void setFeedbackDevice(CANTalon.FeedbackDevice device) {
        m0.setFeedbackDevice(device);
        m1.setFeedbackDevice(device);
    }


    public void enable() {
        m0.enable();
        m1.enable();
    }


    public void enableControl() {
        m0.enableControl();
        m1.enableControl();
    }


    public boolean isControlEnabled() {
        return m0.isControlEnabled() || m1.isControlEnabled();
    }


    public void disableControl() {
        m0.disableControl();
        m1.disableControl();
    }


    public double getP() {
        return (m0.getP() + m1.getP()) / 2;
    }


    public double getI() {
        return (m0.getI() + m1.getI()) / 2;
    }


    public double getD() {
        return (m0.getD() + m1.getD()) / 2;
    }


    public double getF() {
        return (m0.getF() + m1.getF()) / 2;
    }


    public void setP(double p) {
        m0.setP(p);
        m1.setP(p);
    }


    public void setI(double i) {
        m0.setI(i);
        m1.setI(i);
    }


    public void setD(double d) {
        m0.setD(d);
        m1.setD(d);
    }


    public void setF(double f) {
        m0.setF(f);
        m1.setF(f);
    }


    public void setIZone(int izone) {
        m0.setIZone(izone);
        m1.setIZone(izone);
    }


    public double getIZone() {
        return (m0.getIZone() + m1.getIZone()) / 2;
    }


    public void setPID(double p, double i, double d, double f, int izone, double closeLoopRampRate, int profile) {
        m0.setPID(p, i, d, f, izone, closeLoopRampRate, profile);
        m1.setPID(p, i, d, f, izone, closeLoopRampRate, profile);
    }


    public void setPID(double p, double i, double d) {
        m0.setPID(p, i, d);
        m1.setPID(p, i, d);
    }


    public void disable() {
        m0.disable();
        m1.disable();
        this.value = 0;
    }


    public void enableBrakeMode(boolean brake) {
        m0.enableBrakeMode(brake);
        m1.enableBrakeMode(brake);
    }

    public void stopMotors() {
        m0.stopMotor();
        m1.stopMotor();
        this.value = 0;
    }
}
