package org.usfirst.frc.team3863;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    // MOTORS
    public static final int LEFT_DRIVE_MOTOR_0 = 40;
    public static final int LEFT_DRIVE_MOTOR_1 = 41;
    public static final int RIGHT_DRIVE_MOTOR_0 = 31;//32;
    public static final int RIGHT_DRIVE_MOTOR_1 = 32;

    public static final int ARM_MOTOR = 30;
    public static final int END_EFFECTOR_MOTOR = 33;


    // JOYSTICKS
    public static final int RIGHT_JOYSTICK = 1;
    public static final int LEFT_JOYSTICK = 2;


    // ANALOG
    public static final int ARM_ENCODER = 0;
    public static final int PRESSURE_SENSOR = 1;


    // DIGITAL
    public static final int ARM_LIMIT_SWITCH = 0;


    // PNEUMATICS
    public static final int COMPRESSOR = 0;

    public static final int DRIVE_TRAIN_SOLENOID_0 = 0;
    public static final int DRIVE_TRAIN_SOLENOID_1 = 1;
    public static final int ARM_SOLENOID_0 = 2;
    public static final int ARM_SOLENOID_1 = 3;
    public static final int END_EFFECTOR_SOLENOID_0 = 4;
    public static final int END_EFFECTOR_SOLENOID_1 = 5;
}
