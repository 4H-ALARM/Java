package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class ControlCamera extends Command {
    public ControlCamera() { //Allows program to be used for two different directions
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	RobotMap.camera.set((Robot.oi.manipJoystick.getRawAxis(3)+1)*0.5);
    	SmartDashboard.putNumber("Angle", RobotMap.camera.getAngle());
    }

    @Override
    protected void end() {
    	
    }

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
