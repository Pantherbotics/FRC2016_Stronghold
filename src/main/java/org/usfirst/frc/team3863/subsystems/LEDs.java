package org.usfirst.frc.team3863.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Created by Fox on 3/12/2016.
 * Project: 2016Robot
 */
public class LEDs extends Subsystem {

    SerialPort port = new SerialPort(115200, SerialPort.Port.kMXP, 8, SerialPort.Parity.kNone, SerialPort.StopBits.kOne);

    @Override
    protected void initDefaultCommand() {

    }

    public SerialPort getPort() {
        return port;
    }
}
