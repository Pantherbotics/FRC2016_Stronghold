package org.usfirst.frc.team3863;

/**
 * <hr>
 * <h1>Robot Map</h1>
 * <p>Exactly as it sounds: a map of all I/O and other ports</p>
 */
public class RobotMap {

    // MOTORS
    public static final int LEFT_DRIVE_MOTOR_0 = 41;
    public static final int LEFT_DRIVE_MOTOR_1 = 40;
    public static final int RIGHT_DRIVE_MOTOR_0 = 32;//32;
    public static final int RIGHT_DRIVE_MOTOR_1 = 31;

    public static final int ARM_MOTOR = 30;
    public static final int END_EFFECTOR_MOTOR = 33;


    // JOYSTICKS
    public static final int LEFT_JOYSTICK = 0;
    public static final int RIGHT_JOYSTICK = 1;
    public static final int CONTROLLER = 2;


    // ANALOG
    public static final int ARM_ENCODER = 0;
    public static final int BALL_DETECTOR = 1;
    public static final int PRESSURE_SENSOR = 3;


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
    public static final int CENTERING_SOLENOID_0 = 6;
    public static final int CENTERING_SOLENOID_1 = 7;
}
