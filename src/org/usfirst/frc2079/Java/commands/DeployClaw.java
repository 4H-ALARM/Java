package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class DeployClaw extends Command {
	
    public DeployClaw() { //Allows program to be used for two different directions
        requires(Robot.claw);
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	RobotMap.sClawDeploy.set(true);; // Turns the solenoid on.
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.sClawDeploy.set(false);; // Turns the solenoid off.
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
