package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDefault extends CommandGroup{
	public AutoDefault() {
		addParallel(new DriveToLine());
		addParallel(new PlayingPosition());
	}
}
