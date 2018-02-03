package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class TiltClaw extends Command {

	char direction;

    public TiltClaw(char direction) {
    	this.direction=direction;
        requires(Robot.climb);
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	switch(direction){
    		case 'u':	RobotMap.dsClawLift.set(Value.kForward); break;
    		case 'd':	RobotMap.dsClawLift.set(Value.kReverse); break;
    		default:	RobotMap.dsClawLift.set(Value.kOff);
    	}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.dsClawLift.set(Value.kOff);
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
