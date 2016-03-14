package org.usfirst.frc.team3863;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team3863.commands.ChangeCameraCommand;
import org.usfirst.frc.team3863.commands.CompressorControlCommand;
import org.usfirst.frc.team3863.commands.DebugCommand;
import org.usfirst.frc.team3863.commands.arm.DirectDriveArmCommand;
import org.usfirst.frc.team3863.commands.arm.ExtendBigPistonCommand;
import org.usfirst.frc.team3863.commands.drive.AutoTransmissionCommand;
import org.usfirst.frc.team3863.commands.endeffector.IntakeCommand;
import org.usfirst.frc.team3863.commands.endeffector.TimedIntakeCommand;
import org.usfirst.frc.team3863.commands.groups.CenterGroup;
import org.usfirst.frc.team3863.commands.groups.ClimbGroup;
import org.usfirst.frc.team3863.commands.groups.ShootGroup;
import org.usfirst.frc.team3863.util.TriggerCollection;

/**
 * <hr>
 * <h1>Operator Interface</h1>
 * <p>The class that essentially links buttons to joysticks to ports to commands xD</p>
 */
public class OI {

    public CameraServerModded camera = new CameraServerModded();

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
            intakeButton = new JoystickButton(leftJoystick, 2),
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

    public Joystick controller = new Joystick(RobotMap.CONTROLLER);

    public JoystickButton
            contArmUp = new JoystickButton(controller, 6),
            contArmDown = new JoystickButton(controller, 8),
            contFire = new JoystickButton(controller, 1),
            contEject = new JoystickButton(controller, 4),
            contCenter = new JoystickButton(controller, 3),
            contIntake = new JoystickButton(controller, 2),
            contExtend = new JoystickButton(controller, 5),
            contClimb = new JoystickButton(controller, 7),
            contLock = new JoystickButton(controller, 10);


    /**
     * Constructor that registers all the buttons and there respective commands
     */
    public OI() {
        camera.setQuality(50);
        camera.startAutomaticCapture("cam0");


        rightJoyTrigger.whenPressed(new AutoTransmissionCommand.Switch(true));
        leftJoyTrigger.whenPressed(new AutoTransmissionCommand.Switch(false));

        btnArmLower.whenPressed(new DirectDriveArmCommand(true, btnArmLower));
        btnArmRaise.whenPressed(new DirectDriveArmCommand(false, btnArmRaise));
        contArmDown.whenPressed(new DirectDriveArmCommand(true, contArmDown));
        contArmUp.whenPressed(new DirectDriveArmCommand(false, contArmUp));


        rightJoyButton7.whenPressed(new ExtendBigPistonCommand(true));
        rightJoyButton8.whenPressed(new ClimbGroup());
        contClimb.whenPressed(new ClimbGroup());
        new Trigger() {
            @Override
            public boolean get() {
                return contLock.get() && contExtend.get();
            }
        }.whenActive(new ExtendBigPistonCommand(true));

        rightJoyButton11.whenPressed(new CompressorControlCommand(true));
        rightJoyButton12.whenPressed(new CompressorControlCommand(false));

        leftJoyButton10.whenPressed(new ChangeCameraCommand("cam0"));
        leftJoyButton11.whenPressed(new ChangeCameraCommand("cam3"));
//        leftJoyButton10.whenPressed(new PrepareShootGroup());
//        leftJoyButton11.whenPressed(new ClimbGroup());

        leftJoyButton9.whenPressed(new DebugCommand());

        TriggerCollection col = new TriggerCollection(false, intakeButton, contIntake);

        leftJoyButton4.whenPressed(new ShootGroup());
        intakeButton.whenPressed(new IntakeCommand(0.5, col));
        leftJoyButton5.whileHeld(new CenterGroup());
        leftJoyButton3.whenPressed(new TimedIntakeCommand(0.5, 1, true));
        contFire.whenPressed(new ShootGroup());
        contIntake.whenPressed(new IntakeCommand(0.5, col));
        contCenter.whileHeld(new CenterGroup());
        contEject.whenPressed(new TimedIntakeCommand(0.5, 1, true));
    }
}