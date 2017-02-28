package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team4627.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;



public class AngleTurn extends Command {
  
	double desiredAngle;
	double relativeAngle;
	
	public AngleTurn(double angle) {
        // requires driveTrain
    	requires(Robot.driveTrain);
    	desiredAngle = angle;
    	
    	
    }
   /*
    
    // Called just before this Command runs the first time
    protected void initialize() {
    
    Robot.sensors.preAngle = (int)Robot.sensors.getGyroAng();
    relativeAngle = (desiredAngle + Robot.sensors.preAngle);
        
   	System.out.println("Pre Angle: " + Robot.sensors.preAngle);
   	System.out.println("Post Angle: " + Robot.sensors.postAngle);
   	System.out.println("Relative Angle: " + relativeAngle);
    	// Sets the direction of the robot
   		
   		if(relativeAngle > Robot.sensors.preAngle){
    	 Robot.driveTrain.setLeftMotors(-0.75);
         Robot.driveTrain.setRightMotors(0.75);
         
      
   		}
   		if(relativeAngle < Robot.sensors.preAngle){
       	 Robot.driveTrain.setLeftMotors(0.75);
            Robot.driveTrain.setRightMotors(-0.75);
            
         
      		}
   		
    }
    */

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	/*
    	if (relativeAngle <= Robot.sensors.getGyroAng() + 3 && relativeAngle >= Robot.sensors.getGyroAng() - 3) {
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