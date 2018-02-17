package org.usfirst.frc2079.Java;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2079.Java.commands.*;
import org.usfirst.frc2079.Java.subsystems.*;
import org.usfirst.frc2079.Java.subsystems.Climb;

public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Claw claw;
    public static Arm arm;
    public static Climb climb;
    public static AnalogInput pGuage;
    public static AnalogInput sonar;
    
    private static double AutoTime;
        
    
    @Override
    public void robotInit() {
        RobotMap.init();
        driveTrain = new DriveTrain();
        claw = new Claw();
        arm = new Arm();
        climb = new Climb();
        oi = new OI();
        pGuage = new AnalogInput(1);
        sonar = new AnalogInput(3);
        
        CameraServer.getInstance().startAutomaticCapture();
        autonomousCommand = new DriveToLine();
        
        //chooser.addDefault("DriveToLine", new DriveToLine()); //Autonomous command set to DriveToLine
        //SmartDashboard.putData("Auto mode", chooser);
    }

    @Override
    public void disabledInit(){
    	//RobotMap.pneumaticsCompressor1.stop();
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        AutoTime = SmartDashboard.getNumber("AutoTime", 4000.0); //Autonomous timer pulled from SmartDashboard
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        reportPressure();
        reportSonar();
    }

    @Override
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    @Override
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    	reportPressure();
    	reportSonar();
    }
    
    public static double getAutoTime(){
    	return AutoTime;
    }
        
    private void reportPressure() { //report to dash board if pressure is good
    	double p = pGuage.getAverageVoltage(); 
    	
        if (p > 2.5) {
        	// pressure good message to dash board
        	SmartDashboard.putBoolean("atPressure", true);
        }
        else {
        	// pressure low message to dash board
        	SmartDashboard.putBoolean("atPressure", false);
        }
   }
    private void reportSonar() {
    	double h = sonar.getAverageVoltage();
    	SmartDashboard.putNumber("sonarDistance", h);
    }

}
