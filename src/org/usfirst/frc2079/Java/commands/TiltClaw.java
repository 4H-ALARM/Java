package org.usfirst.frc2079.Java.commands;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class TiltClaw extends Command {

	int direction;

    public TiltClaw(int d) { //Allows program to be used for two different directions
    	direction = d;
        //requires(Robot.claw);
    }
    
    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	switch(direction){
    		case 1:	RobotMap.dsClawTilt.set(Value.kForward); break; //If called with 1 set the cylinder to go forwards
    		case -1:	RobotMap.dsClawTilt.set(Value.kReverse); break; //If called with -1 set the cylinder to go backwards
    		default:	RobotMap.dsClawTilt.set(Value.kOff); //Otherwise turn it off
    	}
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    	RobotMap.dsClawTilt.set(Value.kOff); //If it ends also turn it off
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
