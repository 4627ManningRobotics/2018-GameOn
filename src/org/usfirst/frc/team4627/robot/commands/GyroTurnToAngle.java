package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroTurnToAngle extends Command {

	double startHeading;
	double targetHeading;
	double m_angle;
    public GyroTurnToAngle(double angle) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        m_angle=angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startHeading= Robot.sensors.getFused();
    	targetHeading = (startHeading+m_angle)%360;
    	if (targetHeading<0)
    		targetHeading+=360;
    	
    	
    	if (m_angle < 0) {
    		Robot.driveTrain.setLeftMotors(-RobotMap.AUTO_TURN_SPEED);
    		Robot.driveTrain.setRightMotors(RobotMap.AUTO_TURN_SPEED);
    	}
    	else {
    		Robot.driveTrain.setLeftMotors(RobotMap.AUTO_TURN_SPEED);
    		Robot.driveTrain.setRightMotors(-RobotMap.AUTO_TURN_SPEED);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        if (Math.abs(Robot.sensors.getFused() - targetHeading)  < 3 )
    		return true;
    	else return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setRightMotors(0);
    	Robot.driveTrain.setLeftMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
