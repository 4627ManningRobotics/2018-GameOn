package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;
import org.usfirst.frc.team4627.robot.commands.ControlLowGoalOutTake;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class OutTake extends Subsystem {
	
	CANTalon outTakeMotor = new CANTalon(RobotMap.MOTOR_OUT_TAKE);

	public void setMotor(double speed){ 
		
		outTakeMotor.set(speed);
		
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	
    public void initDefaultCommand() {
        setDefaultCommand(new ControlLowGoalOutTake());
    }
}

