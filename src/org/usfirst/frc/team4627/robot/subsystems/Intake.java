package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.IntakeCommand;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon intakeMotor = new CANTalon(RobotMap.MOTOR_INTAKE);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	setDefaultCommand(new IntakeCommand());
    	
    }
    
    public void setInTakeMotor(double speed) {
    	
    	intakeMotor.set(speed);
    	
    }
}

