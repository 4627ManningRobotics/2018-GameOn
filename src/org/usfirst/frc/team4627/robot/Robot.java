
package org.usfirst.frc.team4627.robot;


import org.usfirst.frc.team4627.robot.commands.*;
import org.usfirst.frc.team4627.robot.subsystems.*;

import edu.wpi.first.wpilibj.IterativeRobot;
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

	static public double autoAngle=0;
	static public double autoDist=0;
	Command autonomousCommand;
	SendableChooser<Command> chooserTest = new SendableChooser<>();
	SendableChooser<Command> chooser = new SendableChooser<>();


	
	
	@Override
	public void robotInit() {
		oi = new OI();
		
		try {
			table =  NetworkTable.getTable("DataTable");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//SmartDashboard.putData(new PIDTurnToAngle(90));
		//SmartDashboard.putData(new NTTurnToAngle());
		//SmartDashboard.putData(new AutoPointAtPeg());
		//SmartDashboard.putData(new AutoDriveForward());
		//SmartDashboard.putData(new AutoTurnBack());
		
		//SmartDashboard.putData(new AutoDriveToPeg());
		
		//SmartDashboard.putData("PID", driveTrain.getPIDController());
		
		
		chooserTest.addObject("Left", new LeftGearAuto());
		chooserTest.addObject("Center", new CentreGearAuto());
		chooserTest.addObject("Right", new RightGearAuto());
		chooser.addObject("Left", new LeftGearAuto());
		chooser.addObject("Center", new CentreGearAuto());
		chooser.addObject("Right", new RightGearAuto());
		chooser.addObject("Null", null);
		//chooserTest.addDefault("Null", null);

		SmartDashboard.putData("tester", chooserTest);
		SmartDashboard.putData("Auto", chooser);

		
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
		autonomousCommand = chooserTest.getSelected();
		driveTrain.setForward(true);
		sensors.setLights(true);
		if (autonomousCommand != null)
			autonomousCommand.start();
	}


	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		//printData();
	}

	@Override
	public void teleopInit() {
		sensors.setLights(false);
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
	}


	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		//printData();
	}

	
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	void printData() {
		System.out.print("heading: ");
		System.out.print(sensors.getFused());
		
		System.out.print("  ang: ");
		System.out.print(table.getNumber("Angle", 0));
		System.out.print("  dist: ");
		System.out.print(table.getNumber("Distance", 0));
		System.out.print("  camdist: ");
		System.out.println(table.getNumber("DistFromCamCenter", 0));
		//SmartDashboard.putBoolean("isForward", driveTrain.getForward());

	}
}
