package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CentreGearAuto extends CommandGroup {

    public CentreGearAuto() {
        addSequential(new Wait(1));
        addSequential(new AutoDriveToPeg());
    }
}
