package org.usfirst.frc.team3863.commands.endeffector;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 2/15/2016.
 * Project: 2016Robot
 */
public class IntakeCommand extends BaseCommand {

    @Override
    protected void initialize() {
        intake.intake(0.3);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return !oi.intakeButton.get() && intake.detectorValue() < 4.75;
    }

    @Override
    protected void end() {
        intake.stop();
    }

    @Override
    protected void interrupted() {
        end();
    }

}
