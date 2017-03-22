package org.usfirst.frc.team4627.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCenterGroup extends CommandGroup {

    public AutoCenterGroup() {
        addSequential(new AutoCentreNoCam());
        addSequential(new SetMotors(0.3, -0.3, 0.3));
        addSequential(new SetMotors(-0.3, 0.3, 0.3));
    }
}
