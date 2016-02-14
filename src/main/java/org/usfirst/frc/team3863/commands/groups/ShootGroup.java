package org.usfirst.frc.team3863.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3863.commands.ShootCommand;
import org.usfirst.frc.team3863.commands.TimedIntake;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class ShootGroup extends CommandGroup {

    public ShootGroup() {
        super("Shoot Group");
        addParallel(new ShootCommand());
        addSequential(new TimedIntake(0.25, true));
        addSequential(new TimedIntake(0.5, false));
    }
}
