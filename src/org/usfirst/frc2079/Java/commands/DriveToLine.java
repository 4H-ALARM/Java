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

		requires(Robot.driveTrain);

	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis();
		System.out.println("Time started at:" + start);
		RobotMap.dtSCG1.set(-1.0);
		RobotMap.dtSCG2.set(-1.0);
		t = Robot.getAutoTime();
		System.out.println("t: " + t);
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		if (System.currentTimeMillis() < (start + t)) {
			return false;
		}
		return true;
	}

	@Override
	protected void end() {
		RobotMap.dtSCG1.set(0.0);
		RobotMap.dtSCG2.set(0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
