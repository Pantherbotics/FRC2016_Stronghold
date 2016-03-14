package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * <hr>
 * <h1>Arm Subsystem</h1>
 * <p>The subsystem that handles everything in regards to the arm (-pneumatics).  This includes the EndEffector.</p>
 *
 * @see edu.wpi.first.wpilibj.command.Subsystem
 */
@SuppressWarnings("SameParameterValue")
public class Arm extends Subsystem {
    public CANTalon armMotor = new CANTalon(RobotMap.ARM_MOTOR);

    public AnalogInput magEncoder = new AnalogInput(RobotMap.ARM_ENCODER);

    public double getOffset() {
        return offset;
    }

    double offset = -1.07;

    public Arm() {
        super("Arm Subsystem");
    }

    @Override
    protected void initDefaultCommand() {

    }

    public void logEnc() {
        // MAX 1.4 v
        // MIN 0.1
    }

    public double encVal() {
        return magEncoder.getVoltage() + offset;
    }

    public void lower(double v) {
        armMotor.set(-v);
    }

    public void raise(double v) {
        armMotor.set(v);
    }

    public void stopLift() {
        armMotor.set(0);
    }

    public void update(){
        if(armMotor.isRevLimitSwitchClosed()) offset = - magEncoder.getVoltage();
    }
}
