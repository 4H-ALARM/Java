package org.usfirst.frc2079.Java.commands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class ControlWinch extends Command{
	
	private double speed;
	public ControlWinch(double s){
		speed = s;
		//requires(Robot.climb);
	}
	
	@Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	if(speed == -1 && Robot.oi.reverseWinch()){//handle the reverse of the motor
    		RobotMap.winch.set(speed);
    	}
    	else if(speed > 0){ //handle winch pulling in
    		RobotMap.winch.set(speed); //While this command is being called turn the winch
    	}
    	
    	
    	
    	
    	
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.winch.set(0.0); //Stops the motor when this command isn't called or is interrupted
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
