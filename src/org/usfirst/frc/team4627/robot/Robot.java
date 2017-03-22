
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
	public static DriverTrain driveTrain = new DriverTrain(RobotMap.TIRES_KP, RobotMap.TIRES_KI, RobotMap.TIRES_KD);
	public static Climber climber = new Climber();
	public static Sensors sensors = new Sensors();
	public static OI oi;
	public static Agitator agitator = new Agitator(); 
	public static Intake intake = new Intake();
	public static HighGoal shooters = new HighGoal();

	public static NetworkTable table;
	
	public static SerialPort rs232 = new SerialPort(115200, Port.kOnboard, 8, Parity.kNone, StopBits.kOne);
	public static double distFromCamCenter = 0;
	public static double distance = 0;
	
	
	static public double autoAngle=0;
	static public double autoDist=0;
	Command autonomousCommand;
	SendableChooser<Command> chooserTest = new SendableChooser<>();
	SendableChooser<Command> chooser = new SendableChooser<>();


	
	
	@Override
	public void robotInit() {
		oi = new OI();
		
	//	try {
			
		//} catch (Exception e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}
		
		rs232.enableTermination();
		
		SmartDashboard.putData(new PIDTurnToAngle(65));
		//SmartDashboard.putData(new NTTurnToAngle());
		//SmartDashboard.putData(new AutoPointAtPeg());
		//SmartDashboard.putData(new AutoDriveForward());
		//SmartDashboard.putData(new AutoTurnBack());
		
		//SmartDashboard.putData(new AutoDriveToPeg());
		
		SmartDashboard.putData("PID", driveTrain.getPIDController());
		
		
		chooserTest.addObject("Left", new LeftGearAuto());
		chooserTest.addObject("Center", new CentreGearAuto());
		chooserTest.addObject("Right", new RightGearAuto());
		chooser.addObject("Foo", new LeftGearAuto());
		chooser.addObject("Bar", new CentreGearAuto());
		chooser.addObject("Bat", new RightGearAuto());
		chooser.addObject("Null", null);
		chooserTest.addObject("Null", null);
		chooserTest.addObject("Centre No Cam", new AutoCenterGroup());
		chooserTest.addDefault("Left No Cam", new AutoLeftNoCam());
		chooserTest.addObject("Right No Cam", new AutoRightNoCam());

		SmartDashboard.putData("tester", chooserTest);
		//SmartDashboard.putData("Auto", chooser);
		
		SmartDashboard.putNumber("Distance", distance);
		SmartDashboard.putNumber("DistFromCamCenter", distFromCamCenter);

		
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
		Robot.driveTrain.setPID();
		autonomousCommand = null;// new AutoRightNoCam();//chooserTest.getSelected();
		driveTrain.setForward(true);
		if (autonomousCommand != null)
			autonomousCommand.start();
	}


	@Override
	public void autonomousPeriodic() {
		sensors.setLights(true);


		if (rs232.getBytesReceived() > 0 ) {
			String input = rs232.readString();
			String[] autoValues = input.split(",");
			System.out.println(input);
			if (!autoValues[0].equals("inf"))
				distFromCamCenter = Double.parseDouble(autoValues[0]);
			if (autoValues.length>1) {
				if (!autoValues[1].equals("inf")) {
				distance = Double.parseDouble(autoValues[1]);
				}
			}
		}
		Scheduler.getInstance().run();
		printData();
	}

	@Override
	public void teleopInit() {
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
	}


	@Override
	public void teleopPeriodic() {		
		sensors.setLights(false);

		Scheduler.getInstance().run();
		printData();
	}

	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	void printData() {
		SmartDashboard.putNumber("Heading", sensors.getFused());
		/*
		System.out.print("  P: ");
		System.out.println(driveTrain.getPIDController().getP());
		System.out.print("  I: ");
		System.out.println(driveTrain.getPIDController().getI());
		System.out.print("  D: ");
		System.out.println(driveTrain.getPIDController().getD());
		*/
		
		SmartDashboard.putNumber("Distance", distance);
		SmartDashboard.putNumber("DistFromCamCenter", distFromCamCenter);
		
		//SmartDashboard.putBoolean("isForward", driveTrain.getForward());

	}
}
