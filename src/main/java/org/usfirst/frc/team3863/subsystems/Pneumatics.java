package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * <hr>
 * <h1>Pneumatics Subsystem</h1>
 * <p>The subsystem that handles everything to do with pneumatics, including but not limited to: Solenoids, Compressors, Sensors...</p>
 *
 * @see edu.wpi.first.wpilibj.command.Subsystem
 */
public class Pneumatics extends Subsystem {

    /**
     * <hr>
     * <h1>Compressor</h1>
     * <p>Kinda self explanatory: a reference to the compressor on the bot.</p>
     */
    Compressor compressor;

    /**
     * <hr>
     * <h1>Drive Train Solenoid</h1>
     * <p>The DoubleSolenoid that handles the transmission on the robot.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.DriveTrain
     */
    DoubleSolenoid driveTrainSolenoid = new DoubleSolenoid(RobotMap.DRIVE_TRAIN_SOLENOID_0, RobotMap.DRIVE_TRAIN_SOLENOID_1);

    /**
     * <hr>
     * <h1>Arm Solenoid</h1>
     * <p>The DoubleSolenoid that handles extending the Arm.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.Arm
     */
    DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.ARM_SOLENOID_0, RobotMap.ARM_SOLENOID_1);

    /**
     * <hr>
     * <h1>End Effector Solenoid</h1>
     * <p>The DoubleSolenoid that handles the firing of the launching mechanism.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.Arm
     */
    DoubleSolenoid endEffectorSolenoid = new DoubleSolenoid(RobotMap.END_EFFECTOR_SOLENOID_0, RobotMap.END_EFFECTOR_SOLENOID_1);


    public Pneumatics() {
        super("Pneumatics Subsystem");
        compressor = new Compressor(RobotMap.COMPRESSOR);
        stopCompressor();
    }

    /**
     * <hr>
     * <h1>Fire Solenoid</h1>
     * <p>Fires a DoubleSolenoid in a certain direction.</p>
     */
    public void fireSolenoid(DoubleSolenoid solenoid, DoubleSolenoid.Value direction) {
        if (solenoid.get() != direction) {
            solenoid.set(direction);
        }
    }

    /**
     * <hr>
     * <h1>Toggle Solenoid</h1>
     * <p>Toggles a DoubleSolenoid's direction.</p>
     */
    public void toggleSolenoid(DoubleSolenoid solenoid) {
        if (solenoid.get() == DoubleSolenoid.Value.kForward) {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            solenoid.set(DoubleSolenoid.Value.kForward);
        }
    }

    /**
     * <hr>
     * <h1>Get Compressor</h1>
     * <p>Ya know... I'm not even going to type what this does...</p>
     */
    public Compressor getCompressor() {
        return compressor;
    }

    /**
     * <hr>
     * <h1>Get Drive Train Solenoid</h1>
     * <p>Eh... Returns the DoubleSolenoid that handles the transmission.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.DriveTrain
     */
    public DoubleSolenoid getDriveTrainSolenoid() {
        return driveTrainSolenoid;
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

    /**
     * <hr>
     * <h1>Get End Effector Solenoid</h1>
     * <p>Arg! ANOTHER *#$@$@& method that instead returns the DoubleSolenoid that supposedly causes the EndEffector to fire!</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.Arm
     */
    public DoubleSolenoid getEndEffectorSolenoid() {
        return endEffectorSolenoid;
    }

    /**
     * <hr>
     * <h1>Stop Compressor</h1>
     * <p>Im done....Opposite of startCompressor.</p>
     */
    public void stopCompressor() {
        compressor.stop();
    }

    /**
     * <hr>
     * <h1>Start Compressor</h1>
     * <p>Opposite of stopCompressor.</p>
     */
    public void startCompressor() {
        compressor.start();
    }

    @Override
    protected void initDefaultCommand() {

    }

}
