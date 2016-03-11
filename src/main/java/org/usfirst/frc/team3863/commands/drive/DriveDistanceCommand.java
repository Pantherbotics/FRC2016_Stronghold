package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.CANTalon;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/10/2016.
 * Project: 2016Robot
 */
public class DriveDistanceCommand extends BaseCommand {



    public DriveDistanceCommand() {
        super("Drive Distance Command");
        requires(driveTrain);

    }

    @Override
    protected void initialize() {
        driveTrain.changeControlMode(CANTalon.TalonControlMode.Position);

    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
