package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.Robot;
import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.GTADrive;


import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DriverTrain extends PIDSubsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    	
	
	public double PIDOutput;
	
    	public DriverTrain(double p, double i, double d) {
		super(p, i, d);
		this.getPIDController().setInputRange(0, 360);
    	this.getPIDController().setContinuous(true);
    	this.getPIDController().setOutputRange(-1, 1);
    	this.getPIDController().setAbsoluteTolerance(5);
    	this.getPIDController().setToleranceBuffer(1);
		// TODO Auto-generated constructor stub
	}

		CANTalon topRight = new CANTalon(RobotMap.MOTOR_RIGHT_TOP);
    	CANTalon bottomRight = new CANTalon(RobotMap.MOTOR_RIGHT_BOTTOM);
    	CANTalon topLeft = new CANTalon(RobotMap.MOTOR_LEFT_TOP);
    	CANTalon bottomLeft = new CANTalon(RobotMap.MOTOR_LEFT_BOTTOM);
    	
    	boolean isForward = false;
    
    
    public void setLeftMotors(double speed) {
    	if (isForward){
    		topLeft.set(speed);
    		bottomLeft.set(speed);
    	}else{
    		topLeft.set(-speed);
    		bottomLeft.set(-speed);
    	}
    	
    	
    }
    
    public void setRightMotors(double speed) {
    	if(isForward){
    		topRight.set(-speed);
    		bottomRight.set(-speed);
    	}else{
    		topRight.set(speed);
    		bottomRight.set(speed);
    	}
    }
    
    
    public void toggleForward(){
    	if(isForward){
    		isForward = false;
    	}else{
    		isForward = true;
    	}
    }
    
    public void setForward(boolean bool) {
    	isForward = bool;
    }
    
    public boolean getForward() {
    	return isForward;
    }
    
    public void initDefaultCommand() {
        
    	setDefaultCommand(new GTADrive());
    	
    	
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return Robot.sensors.getFused();
    }

    protected void usePIDOutput(double output) {
    	PIDOutput=output;
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	
    	
    }
    
}

