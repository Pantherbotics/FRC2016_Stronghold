package org.usfirst.frc.team3863.commands;

import org.usfirst.frc.team3863.Utils;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public class CompressorControlCommand extends BaseCommand {

    boolean direction = false;

    public CompressorControlCommand(boolean direction) {
        super("Compressor Control Command");
        this.direction = direction;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        if (direction) {
            Utils.startCompressor();
        } else {
            Utils.stopCompressor();
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
