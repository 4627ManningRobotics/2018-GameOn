package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveToPeg extends Command {

    public AutoDriveToPeg() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double distance = Robot.table.getNumber("Distance", 0)-.3;
    	double time = distance*RobotMap.AUTO_SECPFT;
    	setTimeout(Math.abs(time));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	double dist = Robot.table.getNumber("DistFromCamCenter", 0);
    	//double offset = RobotMap.REGRESSION_M * dist + RobotMap.REGRESSION_B;
    	
    	double angle = -(dist + 110)/3;
    	double setpoint =  (Robot.sensors.getFused()  +  angle)    %360  ;
    	if (setpoint <0) 
    		setpoint+=360;
    	Robot.driveTrain.setSetpoint(   setpoint   );
    	Robot.driveTrain.enable();
    	
    	
    	Robot.driveTrain.setLeftMotors( (-RobotMap.AUTO_SPEED + (Robot.driveTrain.PIDOutput)) );
    	Robot.driveTrain.setRightMotors( (-RobotMap.AUTO_SPEED - (Robot.driveTrain.PIDOutput)) );
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.disable();
    	Robot.driveTrain.setRightMotors(0);
    	Robot.driveTrain.setLeftMotors(0);
  
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
