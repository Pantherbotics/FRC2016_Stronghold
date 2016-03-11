
package org.usfirst.frc.team3863;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3863.commands.BaseCommand;
import org.usfirst.frc.team3863.commands.CompressorControlCommand;

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

    /**
     * <hr>
     * <h1>Robot Initialization</h1>
     * <p>Run when the robot is first started up.</p>
     * <p>Any and all initialization code should be run here.</p>
     */
    public void robotInit() {

        BaseCommand.init();

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
        new CompressorControlCommand(true).start();
        BaseCommand.arm.armMotor.enable();
        BaseCommand.driveTrain.enableMotors();
        BaseCommand.intake.pickupMotor.enable();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
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
