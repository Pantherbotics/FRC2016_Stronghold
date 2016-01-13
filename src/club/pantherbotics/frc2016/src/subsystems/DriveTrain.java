package club.pantherbotics.frc2016.src.subsystems;

import club.pantherbotics.frc2016.src.RobotMap;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends Subsystem {

    private final CANTalon   frontRightMotor, frontLeftMotor, rearRightMotor, rearLeftMotor;
    private final RobotDrive robotDrive;
    private final AnalogGyro gyro;

    public DriveTrain() {
        super();
        rearRightMotor = new CANTalon(RobotMap.BACK_RIGHT_DRIVE_MOTOR);
        rearLeftMotor = new CANTalon(RobotMap.BACK_LEFT_DRIVE_MOTOR);
        frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE_MOTOR);

        robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

        gyro = new AnalogGyro(RobotMap.GRYO);
        LiveWindow.addActuator("Drive Train", "Front_Left Motor", frontLeftMotor);
        LiveWindow.addActuator("Drive Train", "Back Left Motor", rearLeftMotor);
        LiveWindow.addActuator("Drive Train", "Front Right Motor", frontRightMotor);
        LiveWindow.addActuator("Drive Train", "Back Right Motor", rearRightMotor);
        LiveWindow.addSensor("Drive Train", "Gyro", gyro);

    }

    public void log() {
        SmartDashboard.putNumber("Left Position", rearLeftMotor.getEncPosition());
        SmartDashboard.putNumber("Right Position", rearRightMotor.getPosition());
        SmartDashboard.putNumber("Left Speed", rearLeftMotor.getSpeed());
        SmartDashboard.putNumber("Right Speed", rearRightMotor.getSpeed());
        SmartDashboard.putNumber("Gyro", gyro.getAngle());
    }

    /**
     * Tank style driving for the DriveTrain.
     * 
     * @param left
     * @param right
     */
    public void tankDrive(double left, double right) {
        robotDrive.tankDrive(left, right);
    }

    /**
     * Stops all motors in the drive train
     */
    public void stopMotors() {
        robotDrive.stopMotor();
    }

    /**
     * UNTESTED
     * @param joystick
     */
    public void mecanumDrive(Joystick joystick) {
        robotDrive.mecanumDrive_Cartesian(joystick.getX(), joystick.getY(), joystick.getTwist(), gyro.getAngle());
    }

    /**
     * @return The robots heading in degrees.
     */
    public double getHeading() {
        return gyro.getAngle();
    }

    /**
     * Reset the robots sensors to the zero states.
     */
    public void reset() {
        gyro.reset();
    }

    @Override
    protected void initDefaultCommand() {
        // TODO Auto-generated method stub

    }

}
