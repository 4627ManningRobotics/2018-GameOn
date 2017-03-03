
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

//import org.usfirst.frc.team4627.robot.commands.ExampleCommand;
//import org.usfirst.frc.team4627.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DriverTrain driveTrain = new DriverTrain(RobotMap.TIRES_KP, RobotMap.TIRES_KI, RobotMap.TIRES_KD);
	public static Climber climber = new Climber();
	public static Sensors sensors;
	public static OI oi;
	//public static NetworkTable nwtables;
	public static Agitator agitator = new Agitator(); 
	public static Intake intake = new Intake();
	public static HighGoal shooters = new HighGoal();

	public static NetworkTable table;

	static public double autoAngle=0;
	static public double autoDist=0;
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * @apiNote Use table.getNumber("DistFromCamCenter") to get the distance between the gear spike and the center of the camera.
     * @apiNote Use table.getNumber("AreaRatio") to get the area ratio of the two strips of reflective tape.
     * @apiNote Use table.getNumber("DistFromTape") to get the distance from the reflective tape.
     *
     * This should be all we need to figure out the path for the robot to travel.
     *
     * For a concrete example of usage, see here: http://wpilib.screenstepslive.com/s/3120/m/7912/l/80205-writing-a-simple-networktables-program-in-c-and-java-with-a-java-client-pc-side
     */
	
	
	@Override
	public void robotInit() {
		oi = new OI();
		
		try {
			table =  NetworkTable.getTable("DataTable");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		SmartDashboard.putData(new PIDTurnToAngle(90));
		SmartDashboard.putData(new NTTurnToAngle());
		SmartDashboard.putData(new AutoPointAtPeg());
		SmartDashboard.putData(new AutoDriveForward());
		SmartDashboard.putData(new AutoTurnBack());
		SmartDashboard.putData(new AutoDriveToPeg());
		
		SmartDashboard.putData("PID", driveTrain.getPIDController());;
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	
	@Override
	public void autonomousInit() {
		autonomousCommand = new ManualAuto();
		driveTrain.setForward(false);
	
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
	
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
