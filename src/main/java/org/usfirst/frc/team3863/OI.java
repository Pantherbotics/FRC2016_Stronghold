package org.usfirst.frc.team3863;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team3863.commands.ExampleCommand;
import org.usfirst.frc.team3863.wrappers.CANTalonWrapper;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    //// joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    public Joystick leftJoystick = new Joystick(RobotMap.LEFT_JOYSTICK);
    public Joystick rightJoystick = new Joystick(RobotMap.RIGHT_JOYSTICK);
    public Button button = new JoystickButton(leftJoystick, 1);

//    public CANTalon leftMotor = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_0);
//    public CANTalon frontRightWheel = new CANTalon(RobotMap.RIGHT_DRIVE_MOTOR_1);
//    public CANTalon backLeftWheel = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_1);
//    public CANTalon backRightWheel = new CANTalon(RobotMap.LEFT_DRIVE_MOTOR_1);

    public CANTalonWrapper leftMotors = new CANTalonWrapper(RobotMap.LEFT_DRIVE_MOTOR_0,RobotMap.LEFT_DRIVE_MOTOR_1);
    public CANTalonWrapper rightMotors = new CANTalonWrapper(RobotMap.RIGHT_DRIVE_MOTOR_0,RobotMap.RIGHT_DRIVE_MOTOR_1);

    public CANTalon armMotor = new CANTalon(RobotMap.ARM_MOTOR);
    public CANTalon endEffectorMoto = new CANTalon(RobotMap.END_EFFECTOR_MOTOR);


    public Solenoid driveTrainSolenoid = new Solenoid(RobotMap.DRIVE_TRAIN_SOLENOID);
    public Solenoid armSolenoid = new Solenoid(RobotMap.ARM_SOLENOID);
    public Solenoid endEffectorSolenoid = new Solenoid(RobotMap.END_EFFECTOR_SOLENOID);

    public OI() {
        new JoystickButton(leftJoystick,5).whenPressed(new ExampleCommand());
    }


    // There are a few additional built in buttons you can use. Additionally,

    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}
