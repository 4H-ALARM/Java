package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;
import org.usfirst.frc2079.Java.RobotMap;

public class DriveToLine extends Command {

	private long t=4000;
	private long start;

    public DriveToLine() {
    	
        requires(Robot.driveTrain);

    }

    @Override
    protected void initialize() {
    	start = System.currentTimeMillis();
    	RobotMap.dtSCG1.set(-1.0);
    	RobotMap.dtSCG2.set(-1.0);
    }

    @Override
    protected void execute() {
    }

    @Override
    protected boolean isFinished() {
        if(System.currentTimeMillis()<(start+t)){
        	return false;
        }
        return true;
    }

    @Override
    protected void end() {
    	RobotMap.dtSpark1.set(0.0);
    	RobotMap.dtSpark2.set(0.0);
    }

    @Override
    protected void interrupted() {
    	end();
    }
}
