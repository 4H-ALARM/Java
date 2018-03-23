package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveCenter extends Command {

	private long start;
	private double tDrive, tEject;
	private double endTime;

	public DriveCenter() {
	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis(); // Gets the current time in milliseconds
		tDrive = 600;
		tEject = 200;
		endTime = tDrive+tEject;
	}

	@Override

	protected void execute() {
		if(!RobotMap.autoSwitch.get()) {
			if  (System.currentTimeMillis() < (start + tDrive)){
				if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L') {
					RobotMap.dtSCG1.set(0.77); //Drift to left
					RobotMap.dtSCG2.set(-0.80);
				} else if((DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R')) {
					RobotMap.dtSCG1.set(0.79); //Drift to right
					RobotMap.dtSCG2.set(-0.78);
				} 
				else {
					RobotMap.dtSCG1.set(0); //Drift to right
					RobotMap.dtSCG2.set(0);
				}
			}			
			if (System.currentTimeMillis() > (start + tDrive) && (System.currentTimeMillis() < (start + endTime))) {
				Robot.claw.spinWheels(-1.0); //Eject
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() < (start + endTime));
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
