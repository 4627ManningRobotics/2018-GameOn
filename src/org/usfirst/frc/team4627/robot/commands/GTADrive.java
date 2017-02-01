package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GTADrive extends Command {

    public GTADrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	// Marki's test commit
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rightTrigger = Robot.oi.getDriverRawAxis(RobotMap.AXIS_RIGHT_TRIGGER);
    	double leftTrigger = Robot.oi.getDriverRawAxis(RobotMap.AXIS_LEFT_TRIGGER);
    	double leftJoystickXAxis = Robot.oi.getDriverRawAxis(RobotMap.AXIS_LEFT_STICK_X);
    	if(!Robot.driveTrain.getForward()){
    		leftJoystickXAxis  *= -1;
    	}
    	
    	double leftMotors = (rightTrigger - leftTrigger + leftJoystickXAxis);
    	double rightMotors = (rightTrigger - leftTrigger - leftJoystickXAxis);
    	
    	if (leftMotors > RobotMap.ROBOT_MAX_SPEED) {
    		   
    		   leftMotors = RobotMap.ROBOT_MAX_SPEED;
    		   
    	   }
    	   if (rightMotors > RobotMap.ROBOT_MAX_SPEED) {
    		   
    		   rightMotors = RobotMap.ROBOT_MAX_SPEED;
    		   
    	   }
    	   if (leftMotors < RobotMap.ROBOT_MIN_SPEED) {
    		   
    		   leftMotors = RobotMap.ROBOT_MIN_SPEED;
    		   
    	   }
    	   if (rightMotors < RobotMap.ROBOT_MIN_SPEED) {
    		   
    		   rightMotors = RobotMap.ROBOT_MIN_SPEED;
    		   
    	   }
    	   Robot.driveTrain.setLeftMotors(leftMotors);
    	   Robot.driveTrain.setRightMotors(rightMotors);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
