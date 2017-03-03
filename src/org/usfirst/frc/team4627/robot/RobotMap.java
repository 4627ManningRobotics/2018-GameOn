package org.usfirst.frc.team4627.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
		public static final double TIRES_KP = 0.0089;
		public static final double TIRES_KI = 0.0000045;
		public static final double TIRES_KD = 0.00;
	
		//Robot Axis'
		public static final int AXIS_RIGHT_TRIGGER = 3;
		public static final int AXIS_LEFT_TRIGGER = 2;
		public static final int AXIS_LEFT_STICK_X = 0;
		public static final int AXIS_LEFT_STICK_Y = 1;
		public static final int AXIS_RIGHT_STICK_X = 4;
		public static final int AXIS_RIGHT_STICK_Y = 5;
		
		//Robot Buttons
		public static final int BUTTON_A = 1;
		public static final int BUTTON_B = 2;
		public static final int BUTTON_X = 3;
		public static final int BUTTON_Y = 4;
		public static final int BUTTON_LEFT_BUMPER = 5;
		public static final int BUTTON_RIGHT_BUMPER = 6;
		public static final int BUTTON_BACK = 7;
		public static final int BUTTON_START = 8;
		public static final int BUTTON_LEFT_CLICK = 9;
		public static final int BUTTON_RIGHT_CLICK = 10;
		
		//Robot Controllers
		public static final int CONTROLLER_DRIVER = 0;
		public static final int CONTROLLER_OPERATOR = 1;
		public static final int CONTROLLER_OPERATOR_2 = 2;
		
		//Motor Controllers
		public static final int MOTOR_RIGHT_TOP = 2;
		public static final int MOTOR_RIGHT_BOTTOM = 3;
		public static final int MOTOR_LEFT_TOP = 4;
		public static final int MOTOR_LEFT_BOTTOM = 5;
		public static final int MOTOR_CLIMBING = 1;
		public static final int MOTOR_INTAKE = 6;
		public static final int MOTOR_SHOOTER = 7;
		public static final int MOTOR_AGITATOR = 0;
				
		public static final double ROBOT_MAX_SPEED = 0.98;
		public static final double ROBOT_MIN_SPEED = -0.98;
		public static final double ROBOT_MAX_CLIMB_SPEED = 0.98;
		public static final double ROBOT_MIN_CLIMB_SPEED = -0.98;
		public static final double AUTO_TARGET_SPIN_SPEED = 0.5;
		
		public static final int CAMERA_1 = 0;
		public static final int CAMERA_2 = 1;
		
		public static final double SHOOTER_SPEED_FAR = -2000;

		public static final double X_DEADZONE = 0.2;

		public static final double AUTO_SPEED= 0.3;
		public static final double AUTO_SECPFT = .55;

}


