package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToLine extends Command {

	private long start;
	private double t;

	public DriveToLine() {
		// requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis(); // Gets the current time in milliseconds
		// t = Robot.getAutoTime(); //Gets the time length the robot should drive for in milliseconds
		t = 2250;
	}

	@Override

	protected void execute() {
		if(!RobotMap.autoSwitch.get()) {
			RobotMap.dtSCG1.set(0.79);  //
			RobotMap.dtSCG2.set(-0.8); // Robot starts driving
		}
	}

	@Override
	protected boolean isFinished() {
		if (System.currentTimeMillis() < (start + t)) { // When the command is called get the new time, and if it hasn't
														// been 4 seconds since the initial time do not end
			return false;
		}
		return true;
	}

	@Override
	protected void end() {
		RobotMap.dtSCG1.set(0.0);
		RobotMap.dtSCG2.set(0.0); // Stop the motors
	}

	@Override
	protected void interrupted() {
		end();
	}
}
