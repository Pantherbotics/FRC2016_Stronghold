package org.usfirst.frc.team3863.commands.endeffector;

import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 2/15/2016.
 * Project: 2016Robot
 */
public class IntakeCommand extends BaseCommand {

    public final double power;

    public IntakeCommand(double power) {
        super("Intake Command");
        requires(intake);
        this.power = power;
    }

    @Override
    protected void initialize() {
        intake.intake(power);
    }

    @Override
    protected void execute() {

    }

    @Override
    protected boolean isFinished() {
        return !oi.intakeButton.get() && intake.detectorValue() < 4.5;
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
