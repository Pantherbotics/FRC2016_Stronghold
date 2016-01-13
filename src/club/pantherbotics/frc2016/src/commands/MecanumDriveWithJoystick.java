package club.pantherbotics.frc2016.src.commands;

import club.pantherbotics.frc2016.src.OI;
import club.pantherbotics.frc2016.src.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class MecanumDriveWithJoystick extends Command {

    public MecanumDriveWithJoystick() {
        // TODO Auto-generated constructor stub
        requires(Robot.driveTrain);
    }

    @Override
    protected void initialize() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void execute() {
        // TODO Auto-generated method stub
        Robot.driveTrain.mecanumDrive(OI.rightJoystick);
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end() {
        // TODO Auto-generated method stub
        Robot.driveTrain.stopMotors();
    }

    @Override
    protected void interrupted() {
        // TODO Auto-generated method stub
        end();
    }

}
