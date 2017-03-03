package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftGearAuto extends CommandGroup {

    public LeftGearAuto() {
       
    	addSequential(new SetMotors(-RobotMap.AUTO_SPEED, -RobotMap.AUTO_SPEED, RobotMap.AUTO_SIDE_DIST*RobotMap.AUTO_SECPFT));
    	addSequential(new PIDTurnToAngle(65));
    	addSequential(new AutoDriveToPeg());
    }
}
