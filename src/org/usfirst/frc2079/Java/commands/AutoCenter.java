package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoCenter extends CommandGroup{
	public AutoCenter() {
		addParallel(new DriveCenter()); //Drives and 
		addParallel(new PlayingPosition()); //brings arm up
	}
}
