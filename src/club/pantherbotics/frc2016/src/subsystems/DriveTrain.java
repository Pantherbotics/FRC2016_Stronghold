package club.pantherbotics.frc2016.src.subsystems;

import club.pantherbotics.frc2016.src.RobotMap;
import club.pantherbotics.frc2016.src.commands.ExampleCommand;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {

    private final CANTalon   frontRightMotor, frontLeftMotor, rearRightMotor, rearLeftMotor;
    private final RobotDrive robotDrive;

    public DriveTrain() {
        super();
        rearRightMotor = new CANTalon(RobotMap.BACK_RIGHT_DRIVE_MOTOR);
        rearLeftMotor = new CANTalon(RobotMap.BACK_LEFT_DRIVE_MOTOR);
        frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE_MOTOR);
        frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE_MOTOR);

        robotDrive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ExampleCommand());
    }

}
