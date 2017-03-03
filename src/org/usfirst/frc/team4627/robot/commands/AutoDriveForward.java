package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoDriveForward extends Command {

	
    public AutoDriveForward() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double hypotenuse = Robot.autoDist;
    	double angleOne = 90-Math.abs(Robot.autoAngle);
    	
    	double opposite = hypotenuse*Math.cos(angleOne);
    	double time = opposite*RobotMap.AUTO_SECPFT;
    	setTimeout(Math.abs(time));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setLeftMotors(RobotMap.AUTO_SPEED);
    	Robot.driveTrain.setRightMotors(RobotMap.AUTO_SPEED);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
