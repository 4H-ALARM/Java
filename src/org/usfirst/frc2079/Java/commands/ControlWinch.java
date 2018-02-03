package org.usfirst.frc2079.Java.commands;

import org.usfirst.frc2079.Java.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class ControlWinch extends Command{
	
	public ControlWinch(){
		
	}
	
	@Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
		RobotMap.winch.set(1.0);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.winch.set(0.0);
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
