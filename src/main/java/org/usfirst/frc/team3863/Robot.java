
package org.usfirst.frc.team3863;


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

    /**
     * <hr>
     * <h1>Original System Out Stream</h1>
     * <p>Saving a reference to the original System.out in case we ever need to restore from it in the code.</p>
     */
    final PrintStream originalOut = System.out;

    Command autonCommand;
    SendableChooser sendableChooser;

    /**
     * <hr>
     * <h1>Robot Initialization</h1>
     * <p>Run when the robot is first started up.</p>
     * <p>Any and all initialization code should be run here.</p>
     */
    public void robotInit() {

        BaseCommand.init();

        sendableChooser = new SendableChooser();

        sendableChooser.addDefault("Auton On", new CommandGroup() {
            {
                new CompressorControlCommand(true).start();
                BaseCommand.arm.armMotor.enable();
                BaseCommand.driveTrain.enableMotors();
                BaseCommand.intake.pickupMotor.enable();
                new DriveTimeCommand(7.0, 0.7).start();
            }
        });
        sendableChooser.addObject("Auton Off", new Command() {
            @Override
            protected void initialize() {

            }

            @Override
            protected void execute() {

            }

            @Override
            protected boolean isFinished() {
                return true;
            }

            @Override
            protected void end() {

            }

            @Override
            protected void interrupted() {

            }
        });
        SmartDashboard.putData("Auto Mode", sendableChooser);
        //Hackey...
//        PrintStream interceptor = new InterceptorPS(originalOut);
//        System.setOut(interceptor);
    }

    public void disabledInit() {
        SmartDashboard.putString("message", "I'm pretty tired... I think I'll go home now.");
        //Forest Gump:
        //https://www.youtube.com/watch?v=Bw0MBr0Y5x0
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        autonCommand = (Command) sendableChooser.getSelected();

        if (autonCommand != null) autonCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
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
        SmartDashboard.putNumber("Pressure", BaseCommand.pneumatics.getPressure());
    }
}
