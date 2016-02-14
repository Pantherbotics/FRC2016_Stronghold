package org.usfirst.frc.team3863.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.Utils;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public class TransmissionCommand extends BaseCommand {

    private boolean enable = false;

    public TransmissionCommand(boolean enable) {
        requires(driveTrain);
        this.enable = enable;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        System.err.println("WORKING");
        if (enable) {
            Utils.fireSolenoid(driveTrain.getDriveTrainSolenoid(), DoubleSolenoid.Value.kForward);
        } else {
            Utils.fireSolenoid(driveTrain.getDriveTrainSolenoid(), DoubleSolenoid.Value.kReverse);
        }
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
