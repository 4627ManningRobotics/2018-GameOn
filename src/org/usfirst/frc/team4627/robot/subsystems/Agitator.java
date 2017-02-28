package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.ControlAgitator;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Agitator extends Subsystem {
	
	CANTalon motor = new CANTalon(RobotMap.MOTOR_AGITATOR);

	public void setMotor(double speed){ 
		
		motor.set(speed);
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
    public void initDefaultCommand() {
        setDefaultCommand(new ControlAgitator());
    }
}

