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

    }

    @Override
    public void periodic() {

    }

    public void drive(Joystick controller/*L, Joystick controllerR*/){ //Control the left side with the left joystick and the the right side with the right joystick
    	double mult = getMult(controller);  // assume that no scaling is needed
    	double bias = 3.0;  // sets the taper on the hyperbolic curve
    	int p = 1; // 1st order
    	double axis1 = controller.getRawAxis(1);  // read 1st joystick axis
    	double axis2 = controller.getRawAxis(5);  // read 2nd joystick axis
    	double d1 = Math.pow(axis1, p);  // default using a power curve for drive input
    	double d2 = Math.pow(axis2, p);
    	boolean isHyperbolic = true;  // select hyperbolic or power function
    	
    	if (isHyperbolic) {
    		// Use hyperbolic rather than power function
    		d1 = Math.tanh(axis1*bias);
    		d2 = Math.tanh(axis2*bias);       		
    	}
    	
    	// Puts values for throttle speed. Also scales speed unless both triggers are held. 
    	// Input is inverted to match the forward and reverse on the motors
    	motors.tankDrive(-(axis1*mult),-(axis2*mult)); 
    }
    
    public void stop(){ //Stops motors
    	motors.tankDrive(0.0,0.0);
    	
    }
    
    public double getMult(Joystick controller) {
    	if ((controller.getRawAxis(3) == 1) && (controller.getRawAxis(2) == 1)) {
    		return 0.6;
    	} else if (controller.getRawAxis(3) == 1) {
    		return 0.7;
    	} else {
    		return 0.8;
    	}
    }
}

