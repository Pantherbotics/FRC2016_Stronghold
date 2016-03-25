package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;
import org.usfirst.frc.team3863.commands.drive.AdvancedDriveCommand;
import org.usfirst.frc.team3863.commands.drive.AutoTransmissionCommand;

/**
 * Created by Fox on 2/22/2016.
 * Project: 2016Robot
 */
public class Transmission extends Subsystem {

    DoubleSolenoid driveTrainSolenoid = new DoubleSolenoid(RobotMap.DRIVE_TRAIN_SOLENOID_1, RobotMap.DRIVE_TRAIN_SOLENOID_0);


    public DoubleSolenoid getDriveTrainSolenoid() {
        return driveTrainSolenoid;
    }

    @Override
    protected void initDefaultCommand() {
       // setDefaultCommand(AdvancedDriveCommand.getInstance());
    }
}
