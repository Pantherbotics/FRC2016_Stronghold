package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3863.RobotMap;

/**
 * Created by robotics on 2/8/2016.
 */
public class Pneumatics extends Subsystem {
    Compressor compressor;
    DoubleSolenoid driveTrainSolenoid = new DoubleSolenoid(RobotMap.DRIVE_TRAIN_SOLENOID_0, RobotMap.DRIVE_TRAIN_SOLENOID_1);
    DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.ARM_SOLENOID_0, RobotMap.ARM_SOLENOID_1);
    DoubleSolenoid endEffectorSolenoid = new DoubleSolenoid(RobotMap.END_EFFECTOR_SOLENOID_0, RobotMap.END_EFFECTOR_SOLENOID_1);


    public Pneumatics() {
        compressor = new Compressor(RobotMap.COMPRESSOR);
        stopCompressor();
    }

    public void fireSolenoid(DoubleSolenoid solenoid, DoubleSolenoid.Value direction) {
        if (solenoid.get() != direction) {
            solenoid.set(direction);
        }
    }

    public void toggleSolenoid(DoubleSolenoid solenoid) {
        if (solenoid.get() == DoubleSolenoid.Value.kForward) {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            solenoid.set(DoubleSolenoid.Value.kForward);
        }
    }

    public Compressor getCompressor() {
        return compressor;
    }

    public DoubleSolenoid getDriveTrainSolenoid() {
        return driveTrainSolenoid;
    }

    public DoubleSolenoid getArmSolenoid() {
        return armSolenoid;
    }

    public DoubleSolenoid getEndEffectorSolenoid() {
        return endEffectorSolenoid;
    }

    private void stopCompressor() {
        compressor.stop();
    }

    private void startCompressor() {
        compressor.start();
    }

    @Override
    protected void initDefaultCommand() {

    }

}
