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
	private double tDrive1, tDrive2, tEject;
	private double endTime;

	public DriveCenter() {
	}

	@Override
	protected void initialize() {
		start = System.currentTimeMillis(); // Gets the current time in milliseconds
		tDrive1 = 600; 
		tDrive2 = 600;
		tEject = 200;
		endTime = tDrive1+tDrive2+tEject;
	}

	@Override

	protected void execute() {
		if(!RobotMap.autoSwitch.get()) {
			if (DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'L') {
				if  (System.currentTimeMillis() < (start+ tDrive1)) {
					RobotMap.dtSCG1.set(0.77); //Drift to left
 	                RobotMap.dtSCG2.set(-0.80);
 	                System.out.println("left");
				}
 	            if (System.currentTimeMillis() > (start + tDrive1) && System.currentTimeMillis() < (start + (tDrive1 + tDrive2))) {
 	            	RobotMap.dtSCG1.set(0.79); //Drift to right
 					RobotMap.dtSCG2.set(-0.78);
 					System.out.println("right");
 	            }
			} else if((DriverStation.getInstance().getGameSpecificMessage().charAt(0) == 'R')) {
				if  (System.currentTimeMillis() < (start+ tDrive1)) {
					RobotMap.dtSCG1.set(0.79); //Drift to right
 					RobotMap.dtSCG2.set(-0.78);
 					System.out.println("right");
				}
 	            if (System.currentTimeMillis() > (start + tDrive1) && System.currentTimeMillis() < (start + (tDrive1 + tDrive2))) {
 	            	RobotMap.dtSCG1.set(0.77); //Drift to left
 	                RobotMap.dtSCG2.set(-0.80);
 	               System.out.println("left");
 	            }
			} 
			else {
				RobotMap.dtSCG1.set(0); 
				RobotMap.dtSCG2.set(0);
				System.out.println("no");
			}
						
			if (System.currentTimeMillis() > (start + tDrive1+ tDrive2 +2000) && (System.currentTimeMillis() < (start + endTime+3000))) {
				Robot.claw.spinWheels(-1.0); //Eject
			}
		}
	}

	@Override
	protected boolean isFinished() {
		return (System.currentTimeMillis() > (start + endTime+3000));
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
