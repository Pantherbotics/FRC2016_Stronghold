
package org.usfirst.frc.team3863;


import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;
import org.usfirst.frc.team3863.commands.BaseCommand;
import org.usfirst.frc.team3863.commands.CompressorControlCommand;
import us.jfreedman.src.ns.frc.client.NS;
import us.jfreedman.src.ns.frc.common.packets.Packet;
import us.jfreedman.src.ns.frc.common.packets.Packet01;
import us.jfreedman.src.ns.frc.common.packets.Packet02;
import us.jfreedman.src.ns.frc.common.packets.Packet03;

import java.io.PrintStream;

/**
 * <hr>
 * <h1>Le Robot</h1>
 * <p>A class that extends IterativeRobot.... Um yeah...</p>
 */
public class Robot extends IterativeRobot {

//    CameraServer cameraServer = CameraServer.getInstance();

    /**
     * <hr>
     * <h1>Robot Initialization</h1>
     * <p>Run when the robot is first started up.</p>
     * <p>Any and all initialization code should be run here.</p>
     */
    public void robotInit() {
        super.robotInit();
        NS.connect(null, null);

        NS.addQueue(new Packet01("TeST").setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet01("Hello").setDataType(Packet.Type.SERIALIZED), o -> System.out.println("SUCCESS"), null);
        NS.addQueue(new Packet01("HI!").setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet02(5).setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet02(50000).setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet03("Josh", "This is MIKE!").setDataType(Packet.Type.SERIALIZED), null, null);
        NS.addQueue(new Packet03("Mike", "This is JOSH!").setDataType(Packet.Type.SERIALIZED), null, null);

//        cameraServer.setQuality(50);
//        cameraServer.startAutomaticCapture("cam0");
        BaseCommand.init();
    }

    public void disabledInit() {
        SmartDashboard.putString("message", "I'm pretty tired... I think I'll go home now.");
        //Forest Gump:
        //https://www.youtube.com/watch?v=Bw0MBr0Y5x0
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        NS.fireData(null, null);
    }

    public void autonomousInit() {
        new CompressorControlCommand(true).start();
        BaseCommand.arm.armMotor.enable();
        BaseCommand.driveTrain.enableMotors();
        BaseCommand.intake.pickupMotor.enable();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        NS.fireData(null, null);
    }

    public void teleopInit() {
        new CompressorControlCommand(true).start();
        BaseCommand.arm.armMotor.enable();
        BaseCommand.driveTrain.enableMotors();
        BaseCommand.intake.pickupMotor.enable();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        NS.addQueue(new Packet02("Arm", BaseCommand.arm.encVal()), null, null);
        NS.addQueue(new Packet02("Ball", BaseCommand.intake.detectorValue()), null, null);
        NS.fireData(null, null);
    }
}
