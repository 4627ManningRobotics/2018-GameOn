package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CentreGearAuto extends CommandGroup {

    public CentreGearAuto() {
        addSequential(new Wait(1));
        addSequential(new AutoDriveToPeg());
        addSequential(new PIDTurnToAngle(RobotMap.AUTO_GEAR_END_TURN));
    }
}
