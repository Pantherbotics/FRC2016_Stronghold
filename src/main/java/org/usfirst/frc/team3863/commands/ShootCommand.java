package org.usfirst.frc.team3863.commands;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class ShootCommand extends BaseCommand {

    public ShootCommand(double timeout) {
        super("Shoot Command", timeout);
        requires(shooter);
    }

    public ShootCommand() {
        this(0.5);
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
