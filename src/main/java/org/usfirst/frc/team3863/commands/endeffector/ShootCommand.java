package org.usfirst.frc.team3863.commands.endeffector;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class ShootCommand extends BaseCommand {

    public ShootCommand(double timeout) {
        super("Shoot Command", timeout);
        requires(shooter);
        requires(arm);
    }

    public ShootCommand() {
        this(0.15);
    }

    @Override
    protected void initialize() {
        shooter.setShooter(true);
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
        shooter.setShooter(false);
    }

    @Override
    protected void interrupted() {
        end();
    }
}
