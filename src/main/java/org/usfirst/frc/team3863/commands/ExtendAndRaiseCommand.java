package org.usfirst.frc.team3863.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public class ExtendAndRaiseCommand extends CommandGroup {

    public ExtendAndRaiseCommand() {
        addSequential(new ElevateArmToPosCommand(/*1.5*/));
        addParallel(new ElevateArmToPosCommand(/*rest of way*/));
        addSequential(new ExtendBigPistonCommand(true));
    }
}
