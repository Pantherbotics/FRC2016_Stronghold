package org.usfirst.frc.team3863.kotlin.commands

import edu.wpi.first.wpilibj.command.Command
import org.usfirst.frc.team3863.kotlin.OI
import org.usfirst.frc.team3863.kotlin.subsystems.Arm
import org.usfirst.frc.team3863.kotlin.subsystems.DriveTrain
import org.usfirst.frc.team3863.kotlin.subsystems.Pneumatics

/**
 * Created by Joshua Freedman on 2/11/2016.
 * Project: 2016Robot
 */
abstract class BaseCommand : Command {

    constructor(name: String) : super(name) {
    }

    companion object {

        var oi: OI = OI()

        //SubSystems
        var pneumatics = Pneumatics()
        var driveTrain = DriveTrain()
        var arm = Arm()
    }
}
