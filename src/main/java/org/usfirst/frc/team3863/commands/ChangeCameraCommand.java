package org.usfirst.frc.team3863.commands;

/**
 * Created by Fox on 3/11/2016.
 * Project: 2016Robot
 */
public class ChangeCameraCommand extends BaseCommand {


    private String cam;

    public ChangeCameraCommand(String cam) {
        this.cam = cam;
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        oi.camera.startAutomaticCapture(cam);
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
