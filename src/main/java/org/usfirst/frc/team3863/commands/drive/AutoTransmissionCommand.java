package org.usfirst.frc.team3863.commands.drive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team3863.commands.BaseCommand;

/**
 * Created by Fox on 2/20/2016.
 * Project: 2016Robot
 */
public class AutoTransmissionCommand extends BaseCommand {

    public static AutoTransmissionCommand instance;

    public boolean fastMode = false;

    public AutoTransmissionCommand() {
        super("Auto Transmission Command");
        instance = this;
        requires(pneumatics);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (fastMode) {

        } else {
            pneumatics.getDriveTrainSolenoid().set(DoubleSolenoid.Value.kReverse);
        }
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

    public static class Switch extends BaseCommand {

        public final boolean state;

        public Switch(boolean state) {
            this.state = state;
        }

        @Override
        protected void initialize() {
            instance.fastMode = state;
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
}
