package org.usfirst.frc.team3863.commands.arm;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by robotics on 2/9/2016.
 */
public class ExtendBigPistonCommand extends BaseCommand {

    private boolean direction = false;

    public ExtendBigPistonCommand(boolean direction) {
        this.direction = direction;
        requires(pneumatics);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (direction) {
            pneumatics.fireSolenoid(pneumatics.getArmSolenoid(), DoubleSolenoid.Value.kReverse);
        } else {
            pneumatics.fireSolenoid(pneumatics.getArmSolenoid(), DoubleSolenoid.Value.kForward);
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
