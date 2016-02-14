package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * <hr>
 * <h1>Arm Subsystem</h1>
 * <p>The subsystem that handles everything in regards to the arm (-utils).  This includes the EndEffector.</p>
 *
 * @see edu.wpi.first.wpilibj.command.Subsystem
 */
public class Arm extends Subsystem {

    CANTalon armMotor = new CANTalon(RobotMap.ARM_MOTOR);

    AnalogInput magEncoder = new AnalogInput(RobotMap.ARM_ENCODER);

    /**
     * <hr>
     * <h1>Arm Solenoid</h1>
     * <p>The DoubleSolenoid that handles extending the Arm.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.Arm
     */
    DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.ARM_SOLENOID_0, RobotMap.ARM_SOLENOID_1);


    public Arm() {
        super("Arm Subsystem");
    }

    @Override
    protected void initDefaultCommand() {

    }

    public CANTalon getArmMotor() {
        return armMotor;
    }

    public AnalogInput getMagEncoder() {
        return magEncoder;
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

    /**
     * <hr>
     * <h1>Get Arm Solenoid</h1>
     * <p>Meh. Returns the DoubleSolenoid that is responsible for the Arm extending...</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.Arm
     */
    public DoubleSolenoid getArmSolenoid() {
        return armSolenoid;
    }

}
