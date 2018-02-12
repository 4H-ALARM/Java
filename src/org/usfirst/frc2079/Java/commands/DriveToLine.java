package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToLine extends Command {
	
	private long start;
	private double t;
	public DriveToLine() {

		//requires(Robot.driveTrain);

	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis(); //Gets the current time in milliseconds
		System.out.println("Time started at:" + start);
		RobotMap.dtSCG1.set(-1.0);
		RobotMap.dtSCG2.set(-1.0); //Robot starts driving
		t = Robot.getAutoTime(); //Gets the time length the robot should drive for in milliseconds
		System.out.println("t: " + t);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		if (System.currentTimeMillis() < (start + t)) { //When the command is called get the new time, and if it hasn't been 4 seconds since the initial time do not end
			return false;
		}
		return true;
	}

	@Override
	protected void end() {
		RobotMap.dtSCG1.set(0.0);
		RobotMap.dtSCG2.set(0.0); //Stop the motors
	}

	@Override
	protected void interrupted() {
		end();
	}
}
