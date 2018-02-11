package org.usfirst.frc2079.Java.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2079.Java.Robot;

public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {

        requires(Robot.driveTrain);

    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
    	Robot.driveTrain.drive(Robot.oi.driveJoystickL, Robot.oi.driveJoystickR); //Control drive train with xbox controller
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
    }

    @Override
    protected void interrupted() {
    	Robot.driveTrain.stop(); //Stop if interrupted
    }
}
