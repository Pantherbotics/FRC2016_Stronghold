package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
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

    Compressor compressor;

    DoubleSolenoid armSolenoid = new DoubleSolenoid(RobotMap.ARM_SOLENOID_0, RobotMap.ARM_SOLENOID_1);

    AnalogInput pressureTransducer = new AnalogInput(RobotMap.PRESSURE_SENSOR);


    public Pneumatics() {
        super("Pneumatics Subsystem");
        compressor = new Compressor(RobotMap.COMPRESSOR);
        stopCompressor();
    }

    public AnalogInput getPressureTransducer() {
        return pressureTransducer;
    }

    public double getPressureRaw() {
        return pressureTransducer.getAverageVoltage();
    }

    public double getPressure() {
        return Math.max((pressureTransducer.getAverageVoltage() * 43.7) - 51.1, 0);
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

    public DoubleSolenoid getArmSolenoid() {
        return armSolenoid;
    }

    public void stopCompressor() {
        compressor.stop();
    }

    public void startCompressor() {
        compressor.start();
    }

    @Override
    protected void initDefaultCommand() {

    }

}
