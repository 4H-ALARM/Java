package org.usfirst.frc2079.Java.subsystems;

import org.usfirst.frc2079.Java.commands.DriveWithJoysticks;
import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class DriveTrain extends Subsystem {
    private final SpeedController spark1 = RobotMap.dtSpark1;
    private final SpeedController spark2 = RobotMap.dtSpark2;
    private final DifferentialDrive motors = RobotMap.dtDrive;
    
    @Override
    public void initDefaultCommand() {
    	
        setDefaultCommand(new DriveWithJoysticks());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {

    }

    public void drive(Joystick controller/*L, Joystick controllerR*/){ //Control the left side with the left joystick and the the right side with the right joystick
    	motors.tankDrive(-Math.pow(controller.getRawAxis(1), 3),-Math.pow(controller.getRawAxis(5), 3)/*, -Math.pow(controllerR.getY(),3)*/);
    }
    
    public void stop(){ //Stops motors
    	motors.tankDrive(0.0,0.0);
    	
    }
}

