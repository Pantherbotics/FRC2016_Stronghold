package org.usfirst.frc.team3863.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3863.commands.arm.ElevateArmToPosCommand;
import org.usfirst.frc.team3863.commands.arm.ExtendBigPistonCommand;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class ClimbGroup extends CommandGroup{

    public ClimbGroup() {
        super("Climb Group");
        addSequential(new ElevateArmToPosCommand(1.2));
        addSequential(new WaitCommand(3));
        addSequential(new ElevateArmToPosCommand(1.8));
        addSequential(new ExtendBigPistonCommand(true));
        addSequential(new WaitCommand(10));
        addSequential(new ElevateArmToPosCommand(2.37));
        addSequential(new WaitCommand(3));
        addSequential(new ExtendBigPistonCommand(false));


        //2.25
    }


}
