package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LineUpPeg extends Command {

    public LineUpPeg() {
    	
       requires(Robot.driveTrain);
       //requires(Robot.sensors);
  
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	/*
    
   //double xDiff = (Robot.centerX - 160);
   
   //double mappedDiff = xDiff /160;
   if (Robot.nwtables.getNumber("DistFromCamCenter") < 155) { 
   Robot.driveTrain.setLeftMotors(-RobotMap.AUTO_TARGET_SPIN_SPEED);
   Robot.driveTrain.setRightMotors(-RobotMap.AUTO_TARGET_SPIN_SPEED);
   }
   
   if (Robot.nwtables.getNumber("DistFromCamCenter") > 165) {
	   
	Robot.driveTrain.setLeftMotors(RobotMap.AUTO_TARGET_SPIN_SPEED);
	Robot.driveTrain.setRightMotors(RobotMap.AUTO_TARGET_SPIN_SPEED);
	   
   }
    }

    // Make this return true when this Command no longer needs to run execute()

}

*/
    }
	@SuppressWarnings("deprecation")
	protected boolean isFinished() {
		/*
        if(Robot.nwtables.getNumber("DistFromCamCenter") > 155 && Robot.nwtables.getNumber("DistFromCamCenter") < 165) {
        	
        return true;
        	
        } else {
        	
        return false;
        	
        }
        */return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);

    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}