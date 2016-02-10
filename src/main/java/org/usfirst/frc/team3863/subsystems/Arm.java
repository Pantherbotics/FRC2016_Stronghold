package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * Created by robotics on 2/9/2016.
 */
public class Arm extends Subsystem {
    public CANTalon armMotor = new CANTalon(RobotMap.ARM_MOTOR);
    public CANTalon endEffectorMoto = new CANTalon(RobotMap.END_EFFECTOR_MOTOR);

    @Override
    protected void initDefaultCommand() {

    }
}
