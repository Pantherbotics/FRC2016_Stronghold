package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.CANTalon;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/10/2016.
 * Project: 2016Robot
 */
public class DriveDistanceCommand extends BaseCommand {

    final double distance;

    public DriveDistanceCommand(double distance) {
        super("Drive Distance Command");
        requires(driveTrain);
        requires(transmission);
        this.distance = distance;

    }

    @Override
    protected void initialize() {
        driveTrain.changeControlMode(CANTalon.TalonControlMode.Position);
        driveTrain.rightMotors.setPosition(driveTrain.rightMotors.getPosition() + distance);
        driveTrain.leftMotors.setPosition(driveTrain.leftMotors.getPosition() - distance);
    }

    @Override
    protected void execute() {

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
}
