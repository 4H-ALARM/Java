package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class Climb extends CommandGroup {

	private static boolean armRan = false;
	public Climb() {
		if (!armRan){ //Even if the button is still held, the cylinder in the arm will only be called once to reverse direction
			addSequential(new MoveArm('d'));
			armRan = true;
		}
		addSequential(new ControlWinch()); //Winch starts after command before is called
	}
}
