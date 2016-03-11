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
    private CANTalon primary, secondary;
    double value = 0;

    /**
     * <hr>
     * <h1>CANTalonWrapper Constructor</h1>
     * <p>Ports for each motor.</p>
     */
    public CANTalonWrapper(int primary, int secondary) {
        this(primary, secondary, false);
    }

    public double getOutputValue() {
        return value;
    }

    /**
     * <hr>
     * <h1>CANTalonWrapper Constructor</h1>
     * <p>Ports for each motor, and a boolean for if they should be inverted by default.</p>
     */
    public CANTalonWrapper(int primary, int secondary, boolean invert) {
        this.primary = new CANTalon(primary);
        this.secondary = new CANTalon(secondary);
        this.secondary.changeControlMode(CANTalon.TalonControlMode.Follower);
        this.secondary.set(primary);
        setInverted(invert);
    }

    public void set(double outputValue) {
        primary.set(outputValue);
        this.value = outputValue;
    }

    public void setInverted(boolean isInverted) {
        primary.setInverted(isInverted);
        secondary.setInverted(isInverted);
    }

    public boolean getInverted() {
        return primary.getInverted();
    }

    public void set(double outputValue, byte thisValueDoesNotDoAnything) {
        set(outputValue);
    }

    public void reset() {
        primary.reset();
        secondary.reset();
        this.secondary.changeControlMode(CANTalon.TalonControlMode.Follower);
        this.secondary.set(primary.getDeviceID());
        this.value = 0;
    }


    public boolean isEnabled() {
        return primary.isEnabled();
    }


    public double getError() {
        return primary.getError();
    }

    public void setSetpoint(double setpoint) {
        primary.setSetpoint(setpoint);
        secondary.setSetpoint(setpoint);
    }

    public void reverseOutput(boolean flip) {
        primary.reverseOutput(flip);
        secondary.reverseOutput(flip);
    }

    public void reverseSensor(boolean flip) {
        primary.reverseSensor(flip);
    }

    public double get() {
        return (primary.get() + secondary.get()) / 2;
    }

    public int getEncPosition() {
        return (primary.getEncPosition() + secondary.getEncPosition()) / 2;
    }

    public void setEncPosition(int newPosition) {
        primary.setEncPosition(newPosition);
        secondary.setEncPosition(newPosition);
    }

    public int getEncVelocity() {
        return (primary.getEncVelocity() + secondary.getEncVelocity()) / 2;
    }

    public CANTalon.FeedbackDeviceStatus isSensorPresent(CANTalon.FeedbackDevice feedbackDevice) {
        return (primary.isSensorPresent(feedbackDevice).value == 1 || secondary.isSensorPresent(feedbackDevice).value == 1) ? CANTalon.FeedbackDeviceStatus.FeedbackStatusPresent : CANTalon.FeedbackDeviceStatus.FeedbackStatusUnknown;
    }


    public void configEncoderCodesPerRev(int codesPerRev) {
        primary.configEncoderCodesPerRev(codesPerRev);
        secondary.configEncoderCodesPerRev(codesPerRev);
    }


    public double getTemperature() {
        return (primary.getTemperature() + secondary.getTemperature()) / 2;
    }


    public double getOutputCurrent() {
        return (primary.getOutputCurrent() + secondary.getOutputCurrent()) / 2;
    }


    public double getBusVoltage() {
        return (primary.getBusVoltage() + secondary.getBusVoltage()) / 2;
    }


    public double getOutputVoltage() {
        return (primary.getOutputVoltage() + secondary.getOutputVoltage()) / 2;
    }


    public double getPosition() {
        return (primary.getPosition() + secondary.getPosition()) / 2;
    }


    public void setPosition(double pos) {
        primary.setPosition(pos);
        secondary.setPosition(pos);
    }


    public double getSpeed() {
        return (primary.getSpeed() + secondary.getSpeed()) / 2;
    }


    public CANTalon.TalonControlMode getControlMode() {
        return CANTalon.TalonControlMode.valueOf(primary.getControlMode().value & secondary.getControlMode().value);
    }


    public void setControlMode(int mode) {
        primary.setControlMode(mode);
    }


    public void changeControlMode(CANTalon.TalonControlMode controlMode) {
        primary.changeControlMode(controlMode);
    }


    public void setFeedbackDevice(CANTalon.FeedbackDevice device) {
        primary.setFeedbackDevice(device);
    }


    public void enable() {
        primary.enable();
        secondary.enable();
    }


    public void enableControl() {
        primary.enableControl();
        secondary.enableControl();
    }


    public boolean isControlEnabled() {
        return primary.isControlEnabled();
    }


    public void disableControl() {
        primary.disableControl();
        secondary.disableControl();
    }


    public double getP() {
        return primary.getP();
    }


    public double getI() {
        return primary.getI();
    }


    public double getD() {
        return primary.getD();
    }


    public double getF() {
        return primary.getF();
    }


    public void setP(double p) {
        primary.setP(p);
    }


    public void setI(double i) {
        primary.setI(i);
    }


    public void setD(double d) {
        primary.setD(d);
    }


    public void setF(double f) {
        primary.setF(f);
    }


    public void setIZone(int izone) {
        primary.setIZone(izone);
    }


    public double getIZone() {
        return (primary.getIZone() + secondary.getIZone()) / 2;
    }


    public void setPID(double p, double i, double d, double f, int izone, double closeLoopRampRate, int profile) {
        primary.setPID(p, i, d, f, izone, closeLoopRampRate, profile);
    }


    public void setPID(double p, double i, double d) {
        primary.setPID(p, i, d);
    }


    public void disable() {
        primary.disable();
        secondary.disable();
        this.value = 0;
    }


    public void enableBrakeMode(boolean brake) {
        primary.enableBrakeMode(brake);
        secondary.enableBrakeMode(brake);
    }

    public void stopMotors() {
        primary.stopMotor();
        secondary.stopMotor();
        this.value = 0;
    }
}
