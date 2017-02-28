package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ManualAuto extends CommandGroup {

    public ManualAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new SetMotors(0.98, 0.98));
    	addSequential(new Wait(2));
    	
    	addSequential(new SetMotors(0, 0));
    	addSequential(new Wait(4));
    	
    	/*
    	addSequential(new SetMotors(-0.5, -0.5));
    	addSequential(new Wait(0.3));
    	
    	addSequential(new AngleTurn(-50));
    	
    	addSequential(new SetMotors(0.7, 0.7));
    	addSequential(new Wait(2));
    	
    	addSequential(new AngleTurn(50));
    	
    	addSequential(new SetMotors(0.98, 0.98));
    	addSequential(new Wait(3));
    	
    	addSequential(new SetMotors(0, 0)); 
    	*/
    	
    	
    	
    }
}
