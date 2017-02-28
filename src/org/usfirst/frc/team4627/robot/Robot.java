
package org.usfirst.frc.team4627.robot;

import org.usfirst.frc.team4627.robot.commands.ManualAuto;
import org.usfirst.frc.team4627.robot.subsystems.Climber;
import org.usfirst.frc.team4627.robot.subsystems.DriverTrain;
import org.usfirst.frc.team4627.robot.subsystems.HighGoal;
import org.usfirst.frc.team4627.robot.subsystems.Intake;
import org.usfirst.frc.team4627.robot.subsystems.Agitator;
import org.usfirst.frc.team4627.robot.subsystems.Sensors;

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
	public static DriverTrain driveTrain = new DriverTrain();
	public static Climber climber = new Climber();
	//public static Sensors sensors;
	public static OI oi;
	//public static NetworkTable nwtables;
	public static Agitator agitator = new Agitator(); 
	public static Intake intake = new Intake();
	public static HighGoal shooters = new HighGoal();

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
		
		//sensors = new Sensors();
		
		//SmartDashboard.putData("Auto mode", chooser);
		//nwtables = NetworkTable.getTable("DataTable");


		
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

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = new ManualAuto();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
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
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		//System.out.println(nwtables.getNumber("distanceFinal");
		//System.out.println(nwtables.getNumber("isCentered"));
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putData(driveTrain);
		SmartDashboard.putBoolean("isForward", driveTrain.getForward());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
