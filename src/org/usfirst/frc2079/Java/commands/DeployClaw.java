package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class DeployClaw extends Command {

	char direction;
	
    public DeployClaw(char direction) { //Allows program to be used for two different directions
    	this.direction=direction;
        requires(Robot.climb);
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	RobotMap.dsClawDeploy.set(true);; // Turns the solenoid on.
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.dsClawDeploy.set(false);; // Turns the solenoid off.
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
