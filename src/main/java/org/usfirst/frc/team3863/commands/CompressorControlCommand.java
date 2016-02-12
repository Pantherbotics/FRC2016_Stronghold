package org.usfirst.frc.team3863.commands;

/**
 * Created by Joshua Freedman on 2/10/2016.
 * Project: 2016Robot
 */
public class CompressorControlCommand extends BaseCommand {

    boolean direction = false;

    public CompressorControlCommand(boolean direction) {
        super("Compressor Control Command");
        requires(pneumatics);
        this.direction = direction;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (direction) {
            pneumatics.startCompressor();
        } else {
            pneumatics.stopCompressor();
        }
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
