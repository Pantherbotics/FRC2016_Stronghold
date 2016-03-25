package org.usfirst.frc.team3863.commands;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class DebugCommand extends BaseCommand {

    @Override
    protected void initialize() {
        System.out.println("ARM: " + arm.encVal() + "   OFFSET: " + arm.getOffset() + "   BALL: " + intake.detectorValue() );
        System.out.println("PRESSURE: " + pneumatics.getPressureRaw() + "   SPEED-L: " + driveTrain.leftMotors.getSpeed());
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
        end();
    }
}
