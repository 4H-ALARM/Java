package org.usfirst.frc2079.Java;


import org.usfirst.frc2079.Java.commands.ReadPressure;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Victor;

public class RobotMap {
    
    public static SpeedController dtSpark1;
    public static SpeedController dtSpark2;
    public static SpeedControllerGroup dtSCG1;
    
    public static SpeedController dtSpark3;
    public static SpeedController dtSpark4;
    public static SpeedControllerGroup dtSCG2;
    
    public static DifferentialDrive dtDrive;
    
    public static Victor clawLeft;
    public static Victor clawRight;
    public static SpeedControllerGroup clawSCG;

    
    public static SpeedController winch;
    
    public static Compressor compressor;
    public static DoubleSolenoid dsClawTilt;
    public static Solenoid sClawDeploy;
    public static Solenoid sArmControl;
    
    
    public static DigitalInput intakeLimit;
    
    public static AnalogInput ai;
    //public static PowerDistributionPanel pdp;
    
    @SuppressWarnings("deprecation")
	public static void init() {
    	//Drive Train initializations
    	dtSpark1 = new Spark(0);
        LiveWindow.addActuator("DriveTrain", "Spark1", (Spark) dtSpark1);
        dtSpark1.setInverted(false);
        dtSpark2 = new Spark(1);
        LiveWindow.addActuator("DriveTrain", "Spark2", (Spark) dtSpark2);
        dtSpark2.setInverted(false);
        dtSpark3 = new Spark(2);
        LiveWindow.addActuator("DriveTrain", "Spark1", (Spark) dtSpark3);
        dtSpark3.setInverted(false);
        dtSpark4 = new  Spark(3);
        LiveWindow.addActuator("DriveTrain", "Spark2", (Spark) dtSpark4);
        dtSpark4.setInverted(false);
        dtSCG1 = new SpeedControllerGroup(dtSpark1,dtSpark2);//Left side of robot
        dtSCG2 = new SpeedControllerGroup(dtSpark3,dtSpark4);//Right side of robot		
        dtDrive = new DifferentialDrive(dtSCG1,dtSCG2); //Left+Right side of the robot controlled by tank drive controls
        
        dtDrive.setSafetyEnabled(true);
        dtDrive.setExpiration(0.1);
        dtDrive.setMaxOutput(1.0);

        //Claw initializations
        clawLeft = new Victor(8);
        clawLeft.setInverted(false);   
        LiveWindow.addActuator("Claw", "VictorL", clawLeft);
        clawRight = new Victor(9);
        clawRight.setInverted(false);
        LiveWindow.addActuator("Claw", "VictorR", clawRight);
 
        clawSCG = new SpeedControllerGroup(clawLeft, clawRight); //Both claw motors controlled by one command
        
        //Winch initialization
        winch = new Spark(6);
        LiveWindow.addActuator("Winch", "Spark6", (Spark) winch);
        
        //Pneumatics initializations
        compressor = new Compressor(1);
        LiveWindow.addActuator("Pneumatics", "Compressor 1", compressor);
        dsClawTilt = new DoubleSolenoid(1, 0, 1);
        LiveWindow.addActuator("Pneumatics", "Solenoid 1", dsClawTilt);
        sClawDeploy = new Solenoid(1,3);
        LiveWindow.addActuator("Pneumatics", "Solenoid 1", sClawDeploy);
        sArmControl = new Solenoid(1,2);
        LiveWindow.addActuator("Pneumatics", "Double Solenoid 1", sArmControl);
        
        //Limit switch initialization
        intakeLimit = new DigitalInput(4);
        
        // Analogue Input initialization 
        ai = new AnalogInput(0);
    }
}
