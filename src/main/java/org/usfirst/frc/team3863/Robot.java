
package org.usfirst.frc.team3863;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3863.commands.BaseCommand;
import org.usfirst.frc.team3863.commands.CompressorControlCommand;
import org.usfirst.frc.team3863.commands.drive.DriveTimeCommand;

import java.io.PrintStream;

/**
 * <hr>
 * <h1>Le Robot</h1>
 * <p>A class that extends IterativeRobot.... Um yeah...</p>
 */
public class Robot extends IterativeRobot {

    Command autonCommand;
    SendableChooser autonChooser;

    /**
     * <hr>
     * <h1>Robot Initialization</h1>
     * <p>Run when the robot is first started up.</p>
     * <p>Any and all initialization code should be run here.</p>
     */
    public void robotInit() {

        BaseCommand.init();
        autonChooser = new SendableChooser();

        autonChooser.addDefault("Auton On", new CommandGroup() {
            {
                addSequential(new CompressorControlCommand(true));
                addSequential(new DriveTimeCommand(5.0, -0.7));
            }

            @Override
            protected void initialize() {
                super.initialize();
                BaseCommand.arm.armMotor.enable();
                BaseCommand.driveTrain.enableMotors();
                BaseCommand.intake.pickupMotor.enable();
            }
        });
        autonChooser.addObject("Auton Off", new CompressorControlCommand(true));
        SmartDashboard.putData("Auto Mode", autonChooser);
    }

    public void disabledInit() {

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Pressure", BaseCommand.pneumatics.getPressure());
        SmartDashboard.putNumber("Pressure Meter", BaseCommand.pneumatics.getPressure());
    }

    public void autonomousInit() {
        autonCommand = (Command) autonChooser.getSelected();

        if (autonCommand != null) autonCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Pressure", BaseCommand.pneumatics.getPressure());
        SmartDashboard.putNumber("Pressure Meter", BaseCommand.pneumatics.getPressure());
    }

    public void teleopInit() {
        if (autonCommand != null) autonCommand.cancel();

        new CompressorControlCommand(true).start();
        BaseCommand.arm.armMotor.enable();
        BaseCommand.driveTrain.enableMotors();
        BaseCommand.intake.pickupMotor.enable();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        BaseCommand.arm.update();

        SmartDashboard.putNumber("Pressure", BaseCommand.pneumatics.getPressure());
        SmartDashboard.putNumber("Pressure Meter", BaseCommand.pneumatics.getPressure());
    }
}
