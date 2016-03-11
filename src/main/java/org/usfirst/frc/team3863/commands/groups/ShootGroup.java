package org.usfirst.frc.team3863.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import org.usfirst.frc.team3863.commands.arm.ElevateArmToPosCommand;
import org.usfirst.frc.team3863.commands.endeffector.ShootCommand;
import org.usfirst.frc.team3863.commands.endeffector.TimedIntakeCommand;

/**
 * Created by Fox on 2/13/2016.
 * Project: 2016Robot
 */
public class ShootGroup extends CommandGroup {

    public ShootGroup() {
        super("Shoot Group");
        //addSequential(new ElevateArmToPosCommand(2.1, 0.01, 5));
        addSequential(new CenterGroup());
        addSequential(new CenterGroup());
        addSequential(new WaitCommand(0.5));
        addParallel(new TimedIntakeCommand(0.5, 1, true));
        //addSequential(new WaitCommand(0.05));
        addSequential(new ShootCommand(0.08));

        //
    }
}
