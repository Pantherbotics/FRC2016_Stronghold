package org.usfirst.frc.team3863.commands;

/**
 * Created by robotics on 2/9/2016.
 */
public class ExtendBigPistonCommand extends BaseCommand {

    private boolean retract = false;

    public ExtendBigPistonCommand() {
        this(false);
    }

    public ExtendBigPistonCommand(boolean retract) {
        this.retract = retract;
        requires(arm);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        arm.logEnc();
    }

    @Override
    protected boolean isFinished() {
        // TODO Write code that determines when arm finishes and return true;
        return false;
    }

    @Override
    protected void end() {

    }

    @Override
    protected void interrupted() {

    }
}
