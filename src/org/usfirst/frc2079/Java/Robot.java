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
    public static Arm elevator;
    public static Climb climb;

    @Override
    public void robotInit() {
        RobotMap.init();
        driveTrain = new DriveTrain();
        claw = new Claw();
        elevator = new Arm();
        climb = new Climb();
        oi = new OI();

        chooser.addDefault("DriveToLine", new DriveToLine());
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
    
}
