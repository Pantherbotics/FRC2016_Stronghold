package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/11/2016.
 * Project: 2016Robot
 */
@SuppressWarnings("SameParameterValue")
public class DriveTimeCommand extends BaseCommand {

    final double speed;

    public DriveTimeCommand(double timeout, double speed) {
        this.speed = speed;
        requires(driveTrain);
        requires(pneumatics);
        if(timeout > 0){
            setTimeout(timeout);
        } else setTimeout(0.1);
    }

    @Override
    protected void initialize() {
        driveTrain.tankDrive(speed, speed);
        transmission.getDriveTrainSolenoid().set(DoubleSolenoid.Value.kReverse);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return isTimedOut();
    }

    @Override
    protected void end() {
        driveTrain.stopMotors();
    }

    @Override
    protected void interrupted() {
        end();
    }

}
