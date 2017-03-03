package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoGearPlace extends CommandGroup {

    public AutoGearPlace() {
    	addSequential(new AutoPointAtPeg());
    	addSequential(new Wait(1));
    	
        addSequential(new NTTurnToAngle());
        addSequential(new Wait(1));
        
        addSequential(new AutoDriveForward());
        addSequential(new Wait(1));
        
        addSequential(new AutoTurnBack());
        addSequential(new AutoPointAtPeg());
        addSequential(new Wait(1));
        
        addSequential(new AutoDriveToPeg());
    }
}
