package org.usfirst.frc.team4627.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
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
		public static final int RIGHT_MOTOR_1 = 2;
		public static final int RIGHT_MOTOR_2 = 3;
		public static final int LEFT_MOTOR_1 = 4;
		public static final int LEFT_MOTOR_2 = 5;
		public static final int MOTOR_CLIMBING = 1;
		public static final int MOTOR_INTAKE = 6;
		public static final int MOTOR_SHOOTER = 7;
		public static final int MOTOR_AGITATOR = 8;
		
		public static final int CAMERA_1 = 0;
		public static final int CAMERA_2 = 1;
}


