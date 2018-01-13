
package org.usfirst.frc.team4627.robot;


import java.util.Arrays;

import org.usfirst.frc.team4627.robot.commands.*;
import org.usfirst.frc.team4627.robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Parity;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.SerialPort.StopBits;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




public class Robot extends IterativeRobot {
	public static DriveTrain driveTrain = new DriveTrain();
	public static OI oi;
	
	
	static public double autoAngle=0;
	static public double autoDist=0;
	Command autonomousCommand;
	SendableChooser<Command> chooserTest = new SendableChooser<>();
	SendableChooser<Command> chooser = new SendableChooser<>();


	
	
	@Override
	public void robotInit() {
		oi = new OI();
	}


	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void autonomousInit() {
		
	}


	@Override
	public void autonomousPeriodic() {
		this.autonomousCommand = new GyroTurnToAngle(90);
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
	}


	@Override
	public void teleopPeriodic() {
		
	}

	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	void printData() {
		//SmartDashboard.putNumber("Heading", sensors.getFused());
	}
}
