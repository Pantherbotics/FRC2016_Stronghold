package org.usfirst.frc.team3863.commands.endeffector;

import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 2/15/2016.
 * Project: 2016Robot
 */
@SuppressWarnings("SameParameterValue")
public class IntakeCommand extends BaseCommand {

    public final double power;
    public final Trigger activator;

    public IntakeCommand(double power, Trigger activator) {
        super("Intake Command");
        requires(intake);
        this.activator = activator;
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
        return !activator.get() && intake.detectorValue() > 1.7;
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
