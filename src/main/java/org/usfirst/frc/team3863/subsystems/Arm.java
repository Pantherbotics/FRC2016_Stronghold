package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * Created by robotics on 2/9/2016.
 */
public class Arm extends Subsystem {
    public CANTalon armMotor = new CANTalon(RobotMap.ARM_MOTOR);
    public CANTalon endEffectorMoto = new CANTalon(RobotMap.END_EFFECTOR_MOTOR);

    public AnalogInput magEncoder = new AnalogInput(0);

    @Override
    protected void initDefaultCommand() {

    }

    public void logEnc() {
        // MAX 1.4 v
        // MIN 0.1
    }

    public double encVal() {
        return magEncoder.getVoltage();
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
}
