package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public class EndEffector extends Subsystem {
    /**
     * <hr>
     * <h1>End Effector Solenoid</h1>
     * <p>The DoubleSolenoid that handles the firing of the launching mechanism.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.Arm
     */
    DoubleSolenoid endEffectorSolenoid = new DoubleSolenoid(RobotMap.END_EFFECTOR_SOLENOID_0, RobotMap.END_EFFECTOR_SOLENOID_1);
    CANTalon endEffectorMoto = new CANTalon(RobotMap.END_EFFECTOR_MOTOR);

    public EndEffector() {
        super("End Effector Subsystem");
    }


    /**
     * <hr>
     * <h1>Get End Effector Solenoid</h1>
     * <p>Arg! ANOTHER *#$@$@ method that instead returns the DoubleSolenoid that supposedly causes the EndEffector to fire!</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.Arm
     */
    public DoubleSolenoid getEndEffectorSolenoid() {
        return endEffectorSolenoid;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
