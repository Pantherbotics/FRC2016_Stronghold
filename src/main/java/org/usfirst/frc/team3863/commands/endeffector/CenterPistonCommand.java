package org.usfirst.frc.team3863.commands.endeffector;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 3/24/2016.
 * Project: 2016Robot
 */
public class CenterPistonCommand extends BaseCommand {

    public final boolean state;

    public CenterPistonCommand(boolean state) {
        this.state = state;
    }

    @Override
    protected void initialize() {
        shooter.setCenteringSolenoid(state);
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
