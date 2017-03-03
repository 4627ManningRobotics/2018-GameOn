package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PIDTurnToAngle extends Command {

	
	double target;
    public PIDTurnToAngle(double angle) {
    	target=angle;
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveTrain.setSetpoint(   (Robot.sensors.getFused()  +  target)    %360    );
    	Robot.driveTrain.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.setLeftMotors(Robot.driveTrain.PIDOutput);
    	Robot.driveTrain.setRightMotors(-Robot.driveTrain.PIDOutput);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveTrain.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.disable();
    	Robot.driveTrain.setLeftMotors(0);
    	Robot.driveTrain.setRightMotors(0);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
