package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by robotics on 2/9/2016.
 */
public class TransmissionCommand extends BaseCommand {

    private boolean enable = false;

    public TransmissionCommand(boolean enable) {
        requires(transmission);
        this.enable = enable;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (enable) {
            pneumatics.fireSolenoid(transmission.getDriveTrainSolenoid(), DoubleSolenoid.Value.kForward);
        } else {
            pneumatics.fireSolenoid(transmission.getDriveTrainSolenoid(), DoubleSolenoid.Value.kReverse);
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
