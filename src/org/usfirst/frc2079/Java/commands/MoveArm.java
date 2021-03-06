package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class MoveArm extends Command {

	public MoveArm() { 
		requires(Robot.climb);
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		RobotMap.sArmControl.set(true); // Turns the solenoid on.
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		RobotMap.sArmControl.set(false); // Turns the solenoid off.
	}

	@Override
	protected void interrupted() {
		end();
	}
}
