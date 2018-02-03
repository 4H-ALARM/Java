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
    	switch(direction){
    		case 'f':	RobotMap.dsClawDeploy.set(Value.kForward); break; //If called with 'f' set the cylinder to go forwards
    		case 'b':	RobotMap.dsClawDeploy.set(Value.kReverse); break; //If called with 'b' set the cylinder to go backwards
    		default:	RobotMap.dsClawDeploy.set(Value.kOff); //Otherwise turn it off
    	}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.dsClawDeploy.set(Value.kOff); //If it ends also turn it off
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
