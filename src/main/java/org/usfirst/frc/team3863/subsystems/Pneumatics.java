package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import org.usfirst.frc.team3863.RobotMap;

/**
 * Created by robotics on 2/8/2016.
 */
public class Pneumatics {
    public Compressor compressor;

    public Pneumatics() {
        compressor = new Compressor(RobotMap.COMPRESSOR);
        stopCompressor();
    }

    public void fireSolenoid(DoubleSolenoid solenoid) {
        if (solenoid.get() == DoubleSolenoid.Value.kForward) {
            solenoid.set(DoubleSolenoid.Value.kReverse);
        } else {
            solenoid.set(DoubleSolenoid.Value.kForward);
        }
    }

    private void stopCompressor() {
        compressor.stop();
        LiveWindow.addActuator("Pneumatics", "Compressor", compressor);
    }

    private void startCompressor() {
        compressor.start();
    }
}
