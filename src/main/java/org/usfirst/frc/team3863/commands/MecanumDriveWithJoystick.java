package org.usfirst.frc.team3863.commands;

import org.usfirst.frc.team3863.Robot;
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
        Robot.driveTrain.mecanumDrive(Robot.oi.rightJoystick);
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
