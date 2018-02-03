package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class MoveArm extends Command {

	char direction;

    public MoveArm(char direction) {
    	this.direction=direction;
        requires(Robot.climb);
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	switch(direction){
    		case 'u':	RobotMap.dsArmControl.set(Value.kForward); break;
    		case 'd':	RobotMap.dsArmControl.set(Value.kReverse); break;
    		default:	RobotMap.dsArmControl.set(Value.kOff);
    	}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.dsArmControl.set(Value.kOff);
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
