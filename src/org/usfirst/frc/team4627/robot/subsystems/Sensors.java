package org.usfirst.frc.team4627.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Sensors extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	AHRS gyro = new AHRS(I2C.Port.kOnboard);
	public int preAngle;
	public int postAngle;
	
	
	public double getGyroAng() {
		
		double ang = gyro.getAngle();
		
		if(-360 > ang || ang > 360) ang %= 360;
		
		if(ang < 0) ang+=360;
		return ang;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

