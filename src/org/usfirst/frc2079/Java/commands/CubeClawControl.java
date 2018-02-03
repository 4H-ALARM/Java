package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class CubeClawControl extends Command {

	private double s;
	public CubeClawControl(double speed) {
		s = speed;
		requires(Robot.claw);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		if (s < 0 || !limitHit()) { //spitting out the cube or the limit isn't hit
			Robot.claw.spinWheels(s); //run the motors
		}
	}

	@Override
	protected boolean isFinished() {
		if (s < 0) {
			return false;
		}
		return limitHit();
	}

	@Override
	protected void end() {
		Robot.claw.spinWheels(0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}

	private boolean limitHit() {
		return RobotMap.intakeLimit.get();
	}
}
