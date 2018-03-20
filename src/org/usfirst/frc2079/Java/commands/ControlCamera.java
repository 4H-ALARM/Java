package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class ControlCamera extends Command {
	double cameraInit;
	double val;
    public ControlCamera() {
    	
    }
    
    @Override
    protected void initialize() {
    	RobotMap.camera.set(0);
    	val = 0.1;
    	//cameraInit = (Robot.oi.getManipAxis(3)+1)*0.5;
    }

    @Override
    protected void execute() {   //Commented code is optional manip joystick code
    	/*SmartDashboard.putNumber("Angle",RobotMap.camera.getAngle());
    	if (Robot.oi.cameraPresetPressed() && RobotMap.camera.getAngle() == 150) { //If preset camera angle is down switch views
    		RobotMap.camera.setAngle(30);
    	} 
    	else if(Robot.oi.cameraPresetPressed() && RobotMap.camera.getAngle() == 30) { //If camera angle is up switch views
    		RobotMap.camera.setAngle(150);
    	} 
    	else if(Robot.oi.cameraPresetPressed()) { //Default to cube view if neither
    		RobotMap.camera.setAngle(150);
    	}
    	else if((Robot.oi.getManipAxis(3)+1)*0.5 <= cameraInit-0.05 || (Robot.oi.getManipAxis(3)+1)*0.5 >= cameraInit+0.05){ //Manual control
    		RobotMap.camera.set((Robot.oi.getManipAxis(3)+1)*0.5);
    		cameraInit = (Robot.oi.getManipAxis(3)+1)*0.5;
    	}*/
    	
    	if (Robot.oi.getDriveJoy().getRawButton(6)) { //Right Bumper moves camera up
    		RobotMap.camera.set(val);
    		if (val <= 0.97) { val+=0.03; } //Increment
    	} else if (Robot.oi.getDriveJoy().getRawButton(5)) { //Left Bumper moves camera down
    		RobotMap.camera.set(val);
    		if (val >= 0.03) { val -= 0.03; } //Decrement
    	}
    	
    }

    @Override
    protected void end() {
    	
    }

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
