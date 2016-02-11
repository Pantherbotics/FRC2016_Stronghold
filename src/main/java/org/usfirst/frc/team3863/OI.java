package org.usfirst.frc.team3863;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3863.commands.BaseCommand;
import org.usfirst.frc.team3863.commands.DirectDriveArmCommand;
import org.usfirst.frc.team3863.commands.ExtendBigPistonCommand;
import org.usfirst.frc.team3863.commands.TransmissionCommand;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    public Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
    public JoystickButton
            leftJoyTrigger = new JoystickButton(leftJoystick, 1),
            leftJoyButton2 = new JoystickButton(leftJoystick, 2),
            leftJoyButton3 = new JoystickButton(leftJoystick, 3),
            leftJoyButton4 = new JoystickButton(leftJoystick, 4),
            leftJoyButton5 = new JoystickButton(leftJoystick, 5),
            leftJoyButton6 = new JoystickButton(leftJoystick, 6),
            leftJoyButton7 = new JoystickButton(leftJoystick, 7),
            leftJoyButton8 = new JoystickButton(leftJoystick, 8);

    public Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);
    public JoystickButton
            rightJoyTrigger = new JoystickButton(rightJoystick, 1),
            rightJoyButton2 = new JoystickButton(rightJoystick, 2),
            rightJoyButton3 = new JoystickButton(rightJoystick, 3),
            rightJoyButton4 = new JoystickButton(rightJoystick, 4),
            rightJoyButton5 = new JoystickButton(rightJoystick, 5),
            rightJoyButton6 = new JoystickButton(rightJoystick, 6),
            rightJoyButton7 = new JoystickButton(rightJoystick, 7),
            rightJoyButton8 = new JoystickButton(rightJoystick, 8);

    public OI() {
        leftJoyTrigger.whenPressed(new TransmissionCommand(true));
        rightJoyTrigger.whenPressed(new TransmissionCommand(false));

        leftJoyButton3.whenPressed(new DirectDriveArmCommand(true));
        leftJoyButton5.whenPressed(new DirectDriveArmCommand(false));

        /*
        leftJoyButton3.whileHeld(new DirectDriveArmCommand(true));
        leftJoyButton3.whenReleased(new BaseCommand() {

            @Override
            protected void initialize() {

            }

            @Override
            protected void execute() {
                arm.stopLift();
            }

            @Override
            protected boolean isFinished() {
                return true;
            }

            @Override
            protected void end() {

            }

            @Override
            protected void interrupted() {

            }
        });
        leftJoyButton5.whileHeld(new DirectDriveArmCommand(false));
        leftJoyButton5.whenReleased(new BaseCommand() {

            @Override
            protected void initialize() {

            }

            @Override
            protected void execute() {
                arm.stopLift();
            }

            @Override
            protected boolean isFinished() {
                return true;
            }

            @Override
            protected void end() {

            }

            @Override
            protected void interrupted() {

            }
        });
        */
        rightJoyButton2.whenPressed(new ExtendBigPistonCommand());
    }
}
