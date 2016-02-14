package org.usfirst.frc.team3863;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3863.commands.*;
import org.usfirst.frc.team3863.commands.groups.ShootGroup;

/**
 * <hr>
 * <h1>Operator Interface</h1>
 * <p>The class that essentially links buttons to joysticks to ports to commands xD</p>
 */
public class OI {

    /**
     * <hr>
     * Left Joystick
     */
    public Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);

    /**
     * <hr>
     * Left Joystick Buttons...
     */
    public JoystickButton
            rightJoyTrigger = new JoystickButton(rightJoystick, 1),
            rightJoyButton2 = new JoystickButton(rightJoystick, 2),
            btnArmLower = new JoystickButton(rightJoystick, 3),
            rightJoyButton4 = new JoystickButton(rightJoystick, 4),
            btnArmRaise = new JoystickButton(rightJoystick, 5),
            rightJoyButton6 = new JoystickButton(rightJoystick, 6),
            rightJoyButton7 = new JoystickButton(rightJoystick, 7),
            rightJoyButton8 = new JoystickButton(rightJoystick, 8),
            rightJoyButton9 = new JoystickButton(rightJoystick, 9),
            rightJoyButton10 = new JoystickButton(rightJoystick, 10),
            rightJoyButton11 = new JoystickButton(rightJoystick, 11),
            rightJoyButton12 = new JoystickButton(rightJoystick, 12);

    /**
     * <hr>
     * Right Joystick
     */
    public Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);

    /**
     * <hr>
     * Right Joystick Buttons...
     */
    public JoystickButton
            leftJoyTrigger = new JoystickButton(leftJoystick, 1),
            leftJoyButton2 = new JoystickButton(leftJoystick, 2),
            leftJoyButton3 = new JoystickButton(leftJoystick, 3),
            leftJoyButton4 = new JoystickButton(leftJoystick, 4),
            leftJoyButton5 = new JoystickButton(leftJoystick, 5),
            leftJoyButton6 = new JoystickButton(leftJoystick, 6),
            leftJoyButton7 = new JoystickButton(leftJoystick, 7),
            leftJoyButton8 = new JoystickButton(leftJoystick, 8),
            leftJoyButton9 = new JoystickButton(leftJoystick, 9),
            leftJoyButton10 = new JoystickButton(leftJoystick, 10),
            leftJoyButton11 = new JoystickButton(leftJoystick, 11),
            leftJoyButton12 = new JoystickButton(leftJoystick, 12);

    /**
     * Constructor that registers all the buttons and there respective commands
     */
    public OI() {
        rightJoyTrigger.whenPressed(new TransmissionCommand(true));
        leftJoyTrigger.whenPressed(new TransmissionCommand(false));

        btnArmLower.whenPressed(new DirectDriveArmCommand(true));
        btnArmRaise.whenPressed(new DirectDriveArmCommand(false));

        rightJoyButton7.whenPressed(new ExtendBigPistonCommand(true));
        rightJoyButton8.whenPressed(new ExtendBigPistonCommand(false));

        rightJoyButton11.whenPressed(new CompressorControlCommand(true));
        rightJoyButton12.whenPressed(new CompressorControlCommand(false));

        leftJoyButton10.whenPressed(new ShootGroup());
    }
}