package org.usfirst.frc.team3863.commands.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc.team3863.commands.endeffector.TimedIntakeCommand;

/**
 * Created by Fox on 2/15/2016.
 * Project: 2016Robot
 */
public class CenterGroup extends CommandGroup {
    public CenterGroup() {
        super ("Center Group");
        addSequential(new TimedIntakeCommand(0.2, 0.3, true));
        addSequential(new TimedIntakeCommand(0.2, 0.3, false));
    }

    @Override
    public synchronized void cancel() {

    }
}
