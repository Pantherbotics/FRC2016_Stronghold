package org.usfirst.frc.team3863.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3863.commands.endeffector.ShootCommand;
import org.usfirst.frc.team3863.commands.endeffector.TimedIntakeCommand;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class ShootGroup extends CommandGroup {

    public ShootGroup() {
        super("Shoot Group");
        addParallel(new ShootCommand(0.15));
        addSequential(new TimedIntakeCommand(0.1, true));
        addSequential(new TimedIntakeCommand(0.2, false));
    }
}
