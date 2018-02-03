package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class DeployClaw extends Command {

	char direction;
	
    public DeployClaw(char direction) {
    	this.direction=direction;
        requires(Robot.climb);
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	switch(direction){
    		case 'f':	RobotMap.dsClawDeploy.set(Value.kForward); break;
    		case 'b':	RobotMap.dsClawDeploy.set(Value.kReverse); break;
    		default:	RobotMap.dsClawDeploy.set(Value.kOff);
    	}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.dsClawDeploy.set(Value.kOff);
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
