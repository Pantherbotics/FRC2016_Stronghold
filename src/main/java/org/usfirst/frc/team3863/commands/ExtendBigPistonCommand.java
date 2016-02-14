package org.usfirst.frc.team3863.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.Utils;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public class ExtendBigPistonCommand extends BaseCommand {

    private boolean direction = false;

    public ExtendBigPistonCommand(boolean direction) {
        this.direction = direction;
        requires(arm);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (direction) {
            Utils.fireSolenoid(arm.getArmSolenoid(), DoubleSolenoid.Value.kForward);
        } else {
            Utils.fireSolenoid(arm.getArmSolenoid(), DoubleSolenoid.Value.kReverse);
        }
    }

    @Override
    protected boolean isFinished() {
        // TODO Write code that determines when arm finishes and return true;
        return true;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
