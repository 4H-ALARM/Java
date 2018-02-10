package org.usfirst.frc2079.Java;

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
    private static double AutoTime;
    @Override
    public void robotInit() {
        RobotMap.init();
        driveTrain = new DriveTrain();
        claw = new Claw();
        arm = new Arm();
        climb = new Climb();
        oi = new OI();


        chooser.addDefault("DriveToLine", new DriveToLine()); //Autonomous command set to DriveToLine
        SmartDashboard.putData("Auto mode", chooser);
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
        AutoTime = SmartDashboard.getNumber("AutoTime", 1000.0); //Autonomous timer pulled from SmartDashboard
        autonomousCommand = chooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
        
    }

    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public static double getAutoTime(){
    	return AutoTime;
    }
}
