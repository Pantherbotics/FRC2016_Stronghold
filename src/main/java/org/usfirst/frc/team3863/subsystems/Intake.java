package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class Intake extends Subsystem {

    public CANTalon pickupMotor = new CANTalon(RobotMap.END_EFFECTOR_MOTOR);

    @Override
    protected void initDefaultCommand() {

    }

    public void intake(double v) {
        pickupMotor.set(-v);
    }

    public void expell(double v) {
        pickupMotor.set(v);
    }

    public void stop() {
        pickupMotor.set(0);
    }
}
