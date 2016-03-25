package org.usfirst.frc.team3863;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team3863.commands.ChangeCameraCommand;
import org.usfirst.frc.team3863.commands.DebugCommand;
import org.usfirst.frc.team3863.commands.StubCommand;
import org.usfirst.frc.team3863.commands.TestCommand;
import org.usfirst.frc.team3863.commands.arm.DirectDriveArmCommand;
import org.usfirst.frc.team3863.commands.arm.ElevateArmToPosCommand;
import org.usfirst.frc.team3863.commands.arm.ExtendBigPistonCommand;
import org.usfirst.frc.team3863.commands.arm.ZeroArmCommand;
import org.usfirst.frc.team3863.commands.drive.AutoTransmissionCommand;
import org.usfirst.frc.team3863.commands.endeffector.IntakeCommand;
import org.usfirst.frc.team3863.commands.endeffector.TimedIntakeCommand;
import org.usfirst.frc.team3863.commands.groups.CenterGroup;
import org.usfirst.frc.team3863.commands.groups.ClimbGroup;
import org.usfirst.frc.team3863.commands.groups.ShootGroup;

/**
 * <hr>
 * <h1>Operator Interface</h1>
 * <p>The class that essentially links buttons to joysticks to ports to commands xD</p>
 */
public class OI {

    public CameraServerModded camera = new CameraServerModded();

    public Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
    public Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);

    public JoystickButton
            joyButtonTransmissionHigh = new JoystickButton(rightJoystick, 1),
            joyButtonTransmissionLow = new JoystickButton(leftJoystick, 1),
            joyButtonCameraShoot1 = new JoystickButton(leftJoystick, 3),
            joyButtonCameraShoot2 = new JoystickButton(leftJoystick, 5),
            joyButtonCameraDrive1 = new JoystickButton(leftJoystick, 4),
            joyButtonCameraDrive2 = new JoystickButton(leftJoystick, 6),
            joyButtonDebug = new JoystickButton(rightJoystick, 11),
            joyButtonTest = new JoystickButton(rightJoystick, 10),
            joyButtonTurnMode = new JoystickButton(leftJoystick, 7),
            joyButtonArcadeMode = new JoystickButton(rightJoystick, 2);


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


        joyButtonTransmissionHigh.whenPressed(new AutoTransmissionCommand.Switch(true));
        joyButtonTransmissionLow.whenPressed(new AutoTransmissionCommand.Switch(false));

        contArmDown.whenPressed(new DirectDriveArmCommand(true, contArmDown));
        contArmUp.whenPressed(new DirectDriveArmCommand(false, contArmUp));

        contClimb.whenPressed(new ClimbGroup());
        new Trigger() {
            @Override
            public boolean get() {
                return contLock.get() && contExtend.get();
            }
        }.whenActive(new ExtendBigPistonCommand(true));

        new Trigger() {
            @Override
            public boolean get() {
                return joyButtonCameraDrive1.get() || joyButtonCameraDrive2.get();
            }
        }.whenActive(new ChangeCameraCommand("cam0"));

        new Trigger() {
            @Override
            public boolean get() {
                return joyButtonCameraShoot1.get() || joyButtonCameraShoot2.get();
            }
        }.whenActive(new ChangeCameraCommand("cam3"));

        new Trigger() {
            @Override
            public boolean get() {
                return controller.getPOV() == 180;
            }
        }.whenActive(new ZeroArmCommand());

        new Trigger() {
            @Override
            public boolean get() {
                return controller.getPOV() == 270;
            }
        }.whenActive(new ElevateArmToPosCommand(1.08, 0.005, -1, 8));

        new Trigger() {
            @Override
            public boolean get() {
                return controller.getPOV() == 0;
            }
        }.whenActive(new ElevateArmToPosCommand(1.1, 0.005, -1, 8));

        new Trigger() {
            int last;

            @Override
            public boolean get() {
                boolean state = controller.getPOV() != -1 && controller.getPOV() != last;
                last = controller.getPOV();
                return state;
            }
        }.whenActive(new StubCommand() {
            @Override
            protected void initialize() {
                System.out.println(controller.getPOV());
            }
        });

        joyButtonDebug.whenPressed(new DebugCommand());
        joyButtonTest.whenPressed(new TestCommand());

        //TriggerCollection col = new TriggerCollection(false, contIntake);

        contFire.whenPressed(new ShootGroup());
        contIntake.whenPressed(new IntakeCommand(0.5, contIntake));
        contCenter.whileHeld(new CenterGroup());
        contEject.whenPressed(new TimedIntakeCommand(0.5, 1, true));
    }
}