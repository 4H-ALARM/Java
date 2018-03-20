package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoGroup extends CommandGroup{
	public AutoGroup() {
		addParallel(new DriveToLine());
		addParallel(new PlayingPosition());
	}
}
