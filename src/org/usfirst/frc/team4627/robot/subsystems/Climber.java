package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.SetClimbMotor;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	CANTalon climberMotor = new CANTalon(RobotMap.MOTOR_CLIMBING);
	
    public void initDefaultCommand() {
        setDefaultCommand(new SetClimbMotor());
    }
    
    
    public void setClimbMotor(double motorClimbing){
    	
    	climberMotor.set(motorClimbing);
    	
    }
}

