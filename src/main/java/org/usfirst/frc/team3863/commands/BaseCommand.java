package org.usfirst.frc.team3863.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3863.OI;
import org.usfirst.frc.team3863.subsystems.*;

/**
 * Created by robotics on 2/9/2016.
 */
public abstract class BaseCommand extends Command {

    public static OI oi;

    //SubSystems
    public static Pneumatics pneumatics = new Pneumatics();
    public static DriveTrain driveTrain = new DriveTrain();
    public static Arm arm = new Arm();
    public static Shooter shooter = new Shooter();
    public static Intake intake = new Intake();

    public static void init() {
        oi = new OI();
    }

    public BaseCommand() {
        super();
    }

    public BaseCommand(String name) {
        super(name);
    }

    public BaseCommand(String name, double timeout) {
        super(name, timeout);
    }

    public BaseCommand(double timeout) {
        super(timeout);
    }
}
