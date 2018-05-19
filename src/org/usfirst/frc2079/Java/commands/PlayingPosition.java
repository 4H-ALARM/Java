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
	private double tUp;
	private double endTime;

	public PlayingPosition() {
	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis(); // Gets the current time in milliseconds
		tUp = 1700;
		endTime = tUp;
	}

	@Override

	protected void execute() {
			if  (System.currentTimeMillis() < (start + tUp)){
				RobotMap.dsClawTilt.set(Value.kForward); //Tilts up
				RobotMap.sClawDeploy.set(true); //Deploys
			}
			/*if (System.currentTimeMillis() > (start + tUp) && (System.currentTimeMillis() < (start + (tUp + tDown)))) {
				RobotMap.dsClawTilt.set(Value.kReverse); //Tilts down
			 } */
	}

	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() > (start + endTime));
	}

	@Override
	protected void end() {
		RobotMap.dsClawTilt.set(Value.kOff); //Safety
	}

	@Override
	protected void interrupted() {
		end();
	}
}
