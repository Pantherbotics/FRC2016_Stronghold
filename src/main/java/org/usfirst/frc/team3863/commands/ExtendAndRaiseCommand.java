package org.usfirst.frc.team3863.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Created by robotics on 2/9/2016.
 */
public class ExtendAndRaiseCommand extends CommandGroup {

    public ExtendAndRaiseCommand() {
        addSequential(new ElevateArmToPosCommand(/*1.5*/));
        addParallel(new ElevateArmToPosCommand(/*rest of way*/));
        addSequential(new ExtendBigPistonCommand(true));
    }
}
