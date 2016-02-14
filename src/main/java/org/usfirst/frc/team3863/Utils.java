package org.usfirst.frc.team3863;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;

/**
 * <hr>
 * <h1>Utils Subsystem</h1>
 */
public class Utils {

    /**
     * <hr>
     * <h1>Compressor</h1>
     * <p>Kinda self explanatory: a reference to the compressor on the bot.</p>
     */
    static Compressor compressor;

    public Utils() {
        compressor = new Compressor(RobotMap.COMPRESSOR);
        stopCompressor();
    }

    /**
     * <hr>
     * <h1>Fire Solenoid</h1>
     * <p>Fires a DoubleSolenoid in a certain direction.</p>
     */
    public static void fireSolenoid(DoubleSolenoid solenoid, DoubleSolenoid.Value direction) {
        if (solenoid.get() != direction) {
            solenoid.set(direction);
        }
    }

    /**
     * <hr>
     * <h1>Toggle Solenoid</h1>
     * <p>Toggles a DoubleSolenoid's direction.</p>
     */
    public static void toggleSolenoid(DoubleSolenoid solenoid) {
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
    public static Compressor getCompressor() {
        return compressor;
    }

    /**
     * <hr>
     * <h1>Stop Compressor</h1>
     * <p>Im done....Opposite of startCompressor.</p>
     */
    public static void stopCompressor() {
        compressor.stop();
    }

    /**
     * <hr>
     * <h1>Start Compressor</h1>
     * <p>Opposite of stopCompressor.</p>
     */
    public static void startCompressor() {
        compressor.start();
    }

}
