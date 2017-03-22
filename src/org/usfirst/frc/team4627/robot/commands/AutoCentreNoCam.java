package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoCentreNoCam extends Command {

	double heading;
    public AutoCentreNoCam() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	heading = Robot.sensors.getFused();
    	Robot.driveTrain.setSetpoint(heading);
    	Robot.driveTrain.enable();
    	setTimeout(3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setLeftMotors( (-RobotMap.AUTO_SPEED + (Robot.driveTrain.PIDOutput)) );
    	Robot.driveTrain.setRightMotors( (-RobotMap.AUTO_SPEED - (Robot.driveTrain.PIDOutput)) );
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
