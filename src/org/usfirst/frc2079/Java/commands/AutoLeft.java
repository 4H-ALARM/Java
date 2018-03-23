package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoLeft extends CommandGroup{
	public AutoLeft() {
		addParallel(new DriveLeft()); //Drives and
		addParallel(new PlayingPosition()); //brings arm up
	}
}
