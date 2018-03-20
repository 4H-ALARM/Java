package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PlayingPosition extends Command {

	private long start;
	private double tUp, tDown;
	private double endTime;

	public PlayingPosition() {
		// requires(Robot.driveTrain);
	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis(); // Gets the current time in milliseconds
		// t = Robot.getAutoTime(); //Gets the time length the robot should drive for in milliseconds
		tUp = 2000;
		tDown = 2000;
		endTime = 15000;
	}

	@Override

	protected void execute() {
		// if(!RobotMap.autoSwitch.get()) { // Left Or Right
			if  (System.currentTimeMillis() < (start + tUp)){
				RobotMap.dsClawTilt.set(Value.kForward);
				RobotMap.sClawDeploy.set(true);
			}
			// if (System.currentTimeMillis() > (start + tUp) && (System.currentTimeMillis() < (start + (tUp + tDown)))) {
				// RobotMap.dsClawTilt.set(Value.kReverse);
			// }
		/* } else { // Center
			if  (System.currentTimeMillis() < (start + tUp)){
				RobotMap.dsClawTilt.set(Value.kForward);
				RobotMap.sClawDeploy.set(true);
			}
			if (System.currentTimeMillis() > (start + tUp) && (System.currentTimeMillis() < (start + (tUp + tDown)))) {
				Robot.claw.spinWheels(-1);
			}
		*/
		// }
	}

	@Override
	protected boolean isFinished() {
		if (System.currentTimeMillis() < (start + endTime)) { // When the command is called get the new time, and if it hasn't
														// been 4 seconds since the initial time do not end
			return false;
		}
		return true;
	}

	@Override
	protected void end() {
		RobotMap.dsClawTilt.set(Value.kOff);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
