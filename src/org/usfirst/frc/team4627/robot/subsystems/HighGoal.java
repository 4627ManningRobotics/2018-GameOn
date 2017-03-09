package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HighGoal extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon leftShooter = new CANTalon(RobotMap.MOTOR_SHOOTER);
	

	
	public HighGoal() {
		super();
		leftShooter.changeControlMode(TalonControlMode.PercentVbus);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new ShooterAxis());
    }
    
    public void setShooter(double speed) {
    	leftShooter.set(speed);
    }
    

}

