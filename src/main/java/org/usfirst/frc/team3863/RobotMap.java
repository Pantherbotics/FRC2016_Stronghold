package org.usfirst.frc.team3863;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;

    // CAN
    public static final int LEFT_DRIVE_MOTOR_0 = 11;
    public static final int LEFT_DRIVE_MOTOR_1 = 12;
    public static final int RIGHT_DRIVE_MOTOR_0 = 13;
    public static final int RIGHT_DRIVE_MOTOR_1 = 14;

    public static final int ARM_MOTOR = 15;
    public static final int END_EFFECTOR_MOTOR = 16;


    // JOYSTICKS
    public static final int RIGHT_JOYSTICK = 1;
    public static final int LEFT_JOYSTICK = 2;

    // ANALOG
    public static final int GRYO = 1;

    // DIGITAL

    // SPIKE

    // SOLENOID
    public static final int DRIVE_TRAIN_SOLENOID = 1;
    public static final int ARM_SOLENOID = 2;
    public static final int END_EFFECTOR_SOLENOID = 3;
}
