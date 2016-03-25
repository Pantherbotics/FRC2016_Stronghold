package org.usfirst.frc.team3863.commands.arm;

import edu.wpi.first.wpilibj.buttons.Trigger;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Joshua Freedman on 2/10/2016.
 * Project: 2016Robot
 */
public class DirectDriveArmCommand extends BaseCommand {

    boolean direction = false;
    double power = 0.25;

    final Trigger trigger;

    public DirectDriveArmCommand(boolean direction, Trigger trigger) {
        requires(arm);
        this.direction = direction;
        this.trigger = trigger;
    }

    @Override
    protected void initialize() {
        arm.armMotor.enable();
        arm.armMotor.enableControl();
        arm.armMotor.enableBrakeMode(false);
        power = 0.25;
    }

    @Override
    protected void execute() {
        if (direction) {
            arm.lower(power);
        } else {
            arm.raise(power);
        }
        if(power < 0.75){
            power += 0.02;
        }
    }

    @Override
    protected boolean isFinished() {
        return !trigger.get();
    }

    @Override
    protected void end() {
        arm.stopLift();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
