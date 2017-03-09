package org.usfirst.frc.team4627.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	AHRS gyro = new AHRS(I2C.Port.kOnboard);
	Relay backLights = new Relay(0);
	
	public double preAngle;
	public double normAng;
	
	
	public double getAngle(){
		
		double ang = gyro.getAngle();
		if (ang > 360 || ang < -360) ang  %= 360;
		if(ang < 0) ang += 360;
		
		return ang;
		
	}
	
	public void setLights(boolean bool) {
		if (bool)
			backLights.set(Value.kForward);
		else
			backLights.set(Value.kOff);
	}
	
	public double getForwardDisplacement() {
		return -gyro.getDisplacementX();  //based on NAVX orientation
	}
	
	public double getRawAngle() {
		return gyro.getAngle();
	}
	
	public void resetGyro() {
		gyro.reset();
	}
	
	public double getFused() {
		return gyro.getFusedHeading();
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

