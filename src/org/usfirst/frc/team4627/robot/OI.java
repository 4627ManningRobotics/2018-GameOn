package org.usfirst.frc.team4627.robot;

import org.usfirst.frc.team4627.robot.commands.ChangeDirection;
import org.usfirst.frc.team4627.robot.commands.SetMotors;
import org.usfirst.frc.team4627.robot.commands.SetShooterTo;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//Creating Joysticks
	Joystick driver = new Joystick(RobotMap.CONTROLLER_DRIVER);
	Joystick operator = new Joystick(RobotMap.CONTROLLER_OPERATOR);
	
	//Creating Driver Buttons
	Button driverA = new JoystickButton(driver, RobotMap.BUTTON_A);
    Button driverB = new JoystickButton(driver, RobotMap.BUTTON_B);
	Button driverX = new JoystickButton(driver, RobotMap.BUTTON_X);
    Button driverY = new JoystickButton(driver, RobotMap.BUTTON_Y);
	Button driverLeftBumper = new JoystickButton(driver, RobotMap.BUTTON_LEFT_BUMPER);
	Button driverRightBumper = new JoystickButton(driver,RobotMap.BUTTON_RIGHT_BUMPER);
    Button driverBack = new JoystickButton(driver, RobotMap.BUTTON_BACK);
	Button driverStart = new JoystickButton(driver, RobotMap.BUTTON_START);
	Button driverLeftClick = new JoystickButton(driver, RobotMap.BUTTON_LEFT_CLICK);
	Button driverRightClick = new JoystickButton(driver, RobotMap.BUTTON_RIGHT_CLICK);
	
	//Creating Operator Buttons
	Button operatorA = new JoystickButton(operator, RobotMap.BUTTON_A);
	Button operatorB = new JoystickButton(operator, RobotMap.BUTTON_B);
	Button operatorX = new JoystickButton(operator, RobotMap.BUTTON_X);
	Button operatorY = new JoystickButton(operator, RobotMap.BUTTON_Y);
	Button operatorLeftBumper = new JoystickButton(operator, RobotMap.BUTTON_LEFT_BUMPER);
	Button operatorRightBumper = new JoystickButton(operator,RobotMap.BUTTON_RIGHT_BUMPER);
	Button operatorBack = new JoystickButton(operator, RobotMap.BUTTON_BACK);
	Button operatorStart = new JoystickButton(operator, RobotMap.BUTTON_START);
	Button operatorRightClick = new JoystickButton(operator, RobotMap.BUTTON_LEFT_CLICK);
	Button operatorLeftClick = new JoystickButton(operator, RobotMap.BUTTON_RIGHT_CLICK);
	
	public OI(){
	
		driverA.whenPressed(new ChangeDirection());
		operatorA.whenPressed(new SetShooterTo(0));
		operatorB.whenPressed(new SetShooterTo(-.95));
		operatorX.whenPressed(new SetShooterTo(-0.9));
		//driverB.whenPressed(new SetMotors(0.5, 0.5));
		//driverX.whenPressed(new SetMotors(0, 0));
		//driverY.whenPressed(new SetMotors(0.25, 0.25));
		/*driverLeftBumper.whenPressed(null);
		driverRightBumper.whenPressed(null);
		driverBack.whenPressed(null);
		driverStart.whenPressed(null);
		driverLeftClick.whenPressed(null);
		driverRightClick.whenPressed(null);
		
		operatorA.whenPressed(null);
		operatorB.whenPressed(null);
		operatorX.whenPressed(null);
		operatorY.whenPressed(null);
		operatorLeftBumper.whenPressed(null);
		operatorRightBumper.whenPressed(null);
		operatorBack.whenPressed(null);
		operatorStart.whenPressed(null);
		operatorLeftClick.whenPressed(null);
		operatorRightClick.whenPressed(null);
		*/
	}
	
	/**
	 * Gets The Raw Value From The Driver Controller At Given Axis 
	 * @param axis The Controller Axis Number
	 * @return Returns a double for the value
	 */
	public double getDriverRawAxis(int axis){
		double val = driver.getRawAxis(axis);
		if (val>=0)
			return (val*val);
		else
			return (-val*val);
	}
	
	/**
	 * Gets The Raw Value From The Operator Controller At A Given Axis
	 * @param axis The Controller Axis Number
	 * @return Returns a Double Value For The Value
	 */
	public double getOperatorRawAxis(int axis){
		return operator.getRawAxis(axis);
	}
	
}
