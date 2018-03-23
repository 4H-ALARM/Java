package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoRight extends CommandGroup{
	public AutoRight() {
		addParallel(new DriveRight()); //Drives and 
		addParallel(new PlayingPosition()); //brings arm up
	}
}
