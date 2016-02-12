package org.usfirst.frc.team3863.kotlin

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.buttons.JoystickButton
import org.usfirst.frc.team3863.kotlin.commands.DirectDriveArmCommand
import org.usfirst.frc.team3863.kotlin.commands.TransmissionCommand


/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class OI {

    val leftJoystick: Joystick = Joystick(LEFT_JOYSTICK)
    val leftJoyTrigger: JoystickButton = JoystickButton(leftJoystick, 1)
    val leftJoyButton2: JoystickButton = JoystickButton(leftJoystick, 2)
    val leftJoyButton3: JoystickButton = JoystickButton(leftJoystick, 3)
    val leftJoyButton4: JoystickButton = JoystickButton(leftJoystick, 4)
    val leftJoyButton5: JoystickButton = JoystickButton(leftJoystick, 5)
    val leftJoyButton6: JoystickButton = JoystickButton(leftJoystick, 6)
    val leftJoyButton7: JoystickButton = JoystickButton(leftJoystick, 7)
    val leftJoyButton8: JoystickButton = JoystickButton(leftJoystick, 8)

    val rightJoystick: Joystick = Joystick(RIGHT_JOYSTICK)
    val rightJoyTrigger: JoystickButton = JoystickButton(rightJoystick, 1)
    val rightJoyButton2: JoystickButton = JoystickButton(rightJoystick, 2)
    val rightJoyButton3: JoystickButton = JoystickButton(rightJoystick, 3)
    val rightJoyButton4: JoystickButton = JoystickButton(rightJoystick, 4)
    val rightJoyButton5: JoystickButton = JoystickButton(rightJoystick, 5)
    val rightJoyButton6: JoystickButton = JoystickButton(rightJoystick, 6)
    val rightJoyButton7: JoystickButton = JoystickButton(rightJoystick, 7)
    val rightJoyButton8: JoystickButton = JoystickButton(rightJoystick, 8)

    init {
        leftJoyTrigger.whenPressed(TransmissionCommand(true))
        rightJoyTrigger.whenPressed(TransmissionCommand(false))

        leftJoyButton3.whenPressed(DirectDriveArmCommand(true))
        leftJoyButton5.whenPressed(DirectDriveArmCommand(false))
    }
}