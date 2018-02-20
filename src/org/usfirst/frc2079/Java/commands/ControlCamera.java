package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class ControlCamera extends Command {
    public ControlCamera() {
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	RobotMap.camera.set((Robot.oi.getManipAxis(3)+1)*0.5); //Axis is typically with range of -1.0 to 1.0, so it is adjusted for a range of 0.0 to 1.0
    }

    @Override
    protected void end() {
    	
    }

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
