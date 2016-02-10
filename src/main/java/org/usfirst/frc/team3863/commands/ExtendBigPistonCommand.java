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
    }

    @Override
    protected void initialize() {

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
