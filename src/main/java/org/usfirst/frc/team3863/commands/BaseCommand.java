package org.usfirst.frc.team3863.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3863.OI;
import org.usfirst.frc.team3863.Utils;
import org.usfirst.frc.team3863.subsystems.Arm;
import org.usfirst.frc.team3863.subsystems.DriveTrain;
import org.usfirst.frc.team3863.subsystems.EndEffector;
import org.usfirst.frc.team3863.subsystems.Serial;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public abstract class BaseCommand extends Command {

    public static OI oi;

    //SubSystems
    public static EndEffector endEffector = new EndEffector();
    public static Serial serial = new Serial();
    public static DriveTrain driveTrain = new DriveTrain();
    public static Arm arm = new Arm();

    public static void init() {
        oi = new OI();
    }

    public BaseCommand() {
        super();
    }

    public BaseCommand(String name) {
        super(name);
    }
}

