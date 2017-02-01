package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.GTADrive;


import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriverTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    	
    	CANTalon topRight = new CANTalon(RobotMap.MOTOR_RIGHT_TOP);
    	CANTalon bottomRight = new CANTalon(RobotMap.MOTOR_RIGHT_BOTTOM);
    	CANTalon topLeft = new CANTalon(RobotMap.MOTOR_LEFT_TOP);
    	CANTalon bottomLeft = new CANTalon(RobotMap.MOTOR_LEFT_BOTTOM);
    	
    	boolean isForward = true;
    
    
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
    
    
    public void setForward(){
    	if(isForward){
    		isForward = false;
    	}else{
    		isForward = true;
    	}
    }
    
    public boolean getForward() {
    	return isForward;
    }
    
    public void initDefaultCommand() {
        
    	setDefaultCommand(new GTADrive());
    	
    	
    }
}

