package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveLeft extends Command {

	private long start;
	private double tForwards, tTurn, tEject;
	private double endTime;

	public DriveLeft() {
	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis(); // Gets the current time in milliseconds
		tForwards = 1000;
		tTurn = 400;
		tEject = 200;
		endTime = tForwards + tTurn + tEject;
	}

	@Override

	protected void execute() {
		if(!RobotMap.autoSwitch.get()) {
			if  (System.currentTimeMillis() < (start + tForwards)){
				RobotMap.dtSCG1.set(0.79); //Forwards
				RobotMap.dtSCG2.set(-0.80);
			}
				
			if (System.currentTimeMillis() > (start + tForwards) && (System.currentTimeMillis() < (start + (tForwards+tTurn)))) {
				RobotMap.dtSCG1.set(0.79); //Turn to the right
				RobotMap.dtSCG2.set(0.80);
			}
				
			if (System.currentTimeMillis() > (start + (tForwards+tTurn)) && System.currentTimeMillis() < (start + endTime)) {
				Robot.claw.spinWheels(-1.0); //Eject
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() > (start + endTime));
	}

	@Override
	protected void end() {
		RobotMap.dtSCG1.set(0);
		RobotMap.dtSCG2.set(0);
		Robot.claw.spinWheels(0.0);
	}

	@Override
	protected void interrupted() {
		end();
	}
}
