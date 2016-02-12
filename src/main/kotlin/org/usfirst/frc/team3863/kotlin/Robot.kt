package org.usfirst.frc.team3863.kotlin

import edu.wpi.first.wpilibj.IterativeRobot

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
class Robot : IterativeRobot() {

    override fun robotInit() {
        System.setOut(InterceptorPS(System.out))
    }

    override fun autonomousPeriodic() {
        super.autonomousPeriodic()
    }

    override fun autonomousInit() {
        super.autonomousInit()
    }

    override fun teleopInit() {
        super.teleopInit()
    }

    override fun disabledInit() {
        super.disabledInit()
    }

    override fun disabledPeriodic() {
        super.disabledPeriodic()
    }

    override fun teleopPeriodic() {
        super.teleopPeriodic()
    }
}