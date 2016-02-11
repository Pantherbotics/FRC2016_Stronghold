package org.usfirst.frc.team3863.commands;

/**
 * Created by Robotics on 2/10/2016.
 */
public class CompressorControlCommand extends BaseCommand{

    boolean direction = false;

    public CompressorControlCommand(boolean direction){
        super("Compressor Control Command");
        this.direction = direction;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {

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
}
