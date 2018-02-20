package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class CameraPreset extends Command {
    public CameraPreset() {
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	RobotMap.camera.setAngle(150); //Cube sight preset
    }

    @Override
    protected void end() {
    	RobotMap.camera.setAngle(30); //Climb sight preset
    }

	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
