package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoRightNoCam extends CommandGroup {

    public AutoRightNoCam() {
        
    	
    	addSequential(new SetMotors(-RobotMap.AUTO_SPEED, -RobotMap.AUTO_SPEED, RobotMap.AUTO_SIDE_DIST*RobotMap.AUTO_SECPFT));
    	
    	addSequential(new GyroTurnToAngle(-58));
    	//addSequential(new PIDTurnToAngle(-65));
    	addSequential(new SetMotors(-RobotMap.AUTO_SPEED, -RobotMap.AUTO_SPEED, 1.5));
    	addSequential(new SetMotors(0.3, -0.3, 0.3));
        addSequential(new SetMotors(-0.3, 0.3, 0.3));
    }
}
