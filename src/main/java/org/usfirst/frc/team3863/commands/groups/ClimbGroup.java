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
        addSequential(new ExtendBigPistonCommand(false));
        addSequential(new WaitCommand(1));
        addSequential(new ElevateArmToPosCommand(1.35, 0.01, -1, 5));


        //2.25
    }


}
