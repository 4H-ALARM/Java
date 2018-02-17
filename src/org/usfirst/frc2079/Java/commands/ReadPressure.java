package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.AnalogInput;

public class ReadPressure extends Command {
	
	public ReadPressure() {
		
		
	}
	
	public double getPressure() {
		return(RobotMap.ai.getAverageVoltage());
		
	}
	
	protected void displayPressure() {
			
	}
	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {

	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void end() {
	}

}
