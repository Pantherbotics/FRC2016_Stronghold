
package org.usfirst.frc.team3863;


import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3863.commands.ExampleCommand;
import org.usfirst.frc.team3863.subsystems.BaseSubsystem;
import org.usfirst.frc.team3863.subsystems.DriveTrain;

import java.io.PrintStream;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    /**
     * This is a Subsystem
     */
    public static final BaseSubsystem exampleSubsystem = new BaseSubsystem();
    public static OI oi;
    public static final DriveTrain driveTrain = new DriveTrain();

    Command autonomousCommand;
    SendableChooser chooser;

    final PrintStream originalOut = System.out;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

        //Hackey...
        PrintStream interceptor = new InterceptorPS(originalOut);
        System.setOut(interceptor);


        oi = new OI();
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new ExampleCommand());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);

    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    public void disabledInit() {
        SmartDashboard.putString("message", "I'm pretty tired... I think I'll go home now.");
        //Forest Gump:
        //https://www.youtube.com/watch?v=Bw0MBr0Y5x0
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
     * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
     * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
     * below the Gyro
     * <br>
     * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
     * or additional comparisons to the switch structure below with additional strings &amp; commands.
     */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();

		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
        switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */

        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        Robot.oi.leftMotors.enable();
        Robot.oi.leftMotors.enableControl();
        Robot.oi.rightMotors.enable();
        Robot.oi.rightMotors.enableControl();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        if (Robot.oi.leftJoystick.getTrigger()) {
            Robot.oi.driveTrainSolenoid.set(DoubleSolenoid.Value.kForward);
        }
        if (Robot.oi.rightJoystick.getTrigger()) {
            Robot.oi.driveTrainSolenoid.set(DoubleSolenoid.Value.kReverse);
        }

//        SmartDashboard.putData("Compressor", Robot.oi.compressor);
//        SmartDashboard.putData("Solenoid", Robot.oi.driveTrainSolenoid);


        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
