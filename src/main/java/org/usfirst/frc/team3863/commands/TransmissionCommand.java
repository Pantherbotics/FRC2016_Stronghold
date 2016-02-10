package org.usfirst.frc.team3863.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;

/**
 * Created by robotics on 2/9/2016.
 */
public class TransmissionCommand extends BaseCommand {

    private boolean enable = false;

    public TransmissionCommand(boolean enable) {
        requires(pneumatics);
        this.enable = enable;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (enable) {
            pneumatics.fireSolenoid(pneumatics.getDriveTrainSolenoid(), DoubleSolenoid.Value.kForward);
        } else {
            pneumatics.fireSolenoid(pneumatics.getDriveTrainSolenoid(), DoubleSolenoid.Value.kReverse);
        }
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
