package org.usfirst.frc.team4627.robot.subsystems;

import org.usfirst.frc.team4627.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class HighGoal extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon leftShooter = new CANTalon(RobotMap.MOTOR_SHOOTER);
	
	boolean isShooting = false;
	
	public HighGoal() {
		super();
		leftShooter.changeControlMode(TalonControlMode.Speed);
		leftShooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Absolute);
		leftShooter.setPID(0.3, 0, 0, .025, 0, 0, 0);
		leftShooter.setSetpoint(0);
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void beginShooting(){
    	leftShooter.setSetpoint(RobotMap.SHOOTER_SPEED_FAR);
    	isShooting = true;
    }
    
    public void endShooting() {
    	leftShooter.setSetpoint(0);
    	isShooting = false;
    }
    
    public boolean getIsShooting() {
    	return isShooting;
    }
}

