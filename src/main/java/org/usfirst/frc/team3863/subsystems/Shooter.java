package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class Shooter extends Subsystem {

    public DoubleSolenoid endEffectorSolenoid = new DoubleSolenoid(RobotMap.END_EFFECTOR_SOLENOID_0, RobotMap.END_EFFECTOR_SOLENOID_1);

    public DoubleSolenoid centeringSolenoid = new DoubleSolenoid(RobotMap.CENTERING_SOLENOID_0, RobotMap.CENTERING_SOLENOID_1);

    @Override
    protected void initDefaultCommand() {

    }

    public void setShooter(boolean extended){
        endEffectorSolenoid.set(extended ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    }

    public void setCenteringSolenoid(boolean extended){
        centeringSolenoid.set(extended ? DoubleSolenoid.Value.kReverse : DoubleSolenoid.Value.kForward);
    }


}
