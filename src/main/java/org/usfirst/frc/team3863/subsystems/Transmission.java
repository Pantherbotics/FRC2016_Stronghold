package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team3863.RobotMap;
import org.usfirst.frc.team3863.commands.drive.AutoTransmissionCommand;

/**
 * Created by Fox on 2/22/2016.
 * Project: 2016Robot
 */
public class Transmission extends Subsystem {

    /**
     * <hr>
     * <h1>Drive Train Solenoid</h1>
     * <p>The DoubleSolenoid that handles the transmission on the robot.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.DriveTrain
     */
    DoubleSolenoid driveTrainSolenoid = new DoubleSolenoid(RobotMap.DRIVE_TRAIN_SOLENOID_0, RobotMap.DRIVE_TRAIN_SOLENOID_1);


    /**
     * <hr>
     * <h1>Get Drive Train Solenoid</h1>
     * <p>Eh... Returns the DoubleSolenoid that handles the transmission.</p>
     *
     * @see org.usfirst.frc.team3863.subsystems.DriveTrain
     */
    public DoubleSolenoid getDriveTrainSolenoid() {
        return driveTrainSolenoid;
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new AutoTransmissionCommand());
    }
}
