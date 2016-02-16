package org.usfirst.frc.team3863.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3863.commands.arm.ElevateArmToPosCommand;

/**
 * Created by Sam on 2/15/2016.
 */
public class PrepareShootGroup extends CommandGroup {

    public PrepareShootGroup() {
        addSequential(new ElevateArmToPosCommand(2.575));
//        addSequential(new ShootGroup());
    }
}
