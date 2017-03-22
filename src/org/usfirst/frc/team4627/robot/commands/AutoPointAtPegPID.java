package org.usfirst.frc.team4627.robot.commands;

import org.usfirst.frc.team4627.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoPointAtPegPID extends Command {

		double angle;
    public AutoPointAtPegPID() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveTrain);
        }

        // Called just before this Command runs the first time
        protected void initialize() {
        	
        }

        // Called repeatedly when this Command is scheduled to run
        protected void execute() {
        	angle = -Robot.distFromCamCenter/5;
        	System.out.println(angle);
        	double setpoint =  (Robot.sensors.getFused()  +  angle)    %360  ;
        	if (setpoint <0) 
        		setpoint+=360;
        	Robot.driveTrain.setSetpoint(   setpoint   );
        	Robot.driveTrain.enable();
        	
        	
        	Robot.driveTrain.setLeftMotors(Robot.driveTrain.PIDOutput);
        	Robot.driveTrain.setRightMotors(-Robot.driveTrain.PIDOutput);
        }

        // Make this return true when this Command no longer needs to run execute()
        protected boolean isFinished() {
        	if (Math.abs(angle) < 3 )
        		return true;
        	else
        		return false;
        	
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
