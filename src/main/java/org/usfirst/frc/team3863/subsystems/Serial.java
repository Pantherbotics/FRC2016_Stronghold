package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Originally Created by Joshua Freedman on 2/9/2016.
 * Project: 2016Robot
 */
public class Serial extends Subsystem {

    SerialPort serialPort = new SerialPort(0, SerialPort.Port.kOnboard);

    public Serial() {
        super("Serial Subsystem");
        serialPort.reset();
    }

    public SerialPort getSerialPort() {
        return serialPort;
    }

    @Override
    protected void initDefaultCommand() {

    }
}
