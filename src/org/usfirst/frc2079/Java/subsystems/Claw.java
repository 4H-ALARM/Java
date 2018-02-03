package org.usfirst.frc2079.Java.subsystems;

import org.usfirst.frc2079.Java.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Claw extends Subsystem {
    private final SpeedControllerGroup clawSCG = RobotMap.clawSCG;
    
    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {

    }
    
    public void spinWheels(double speed){
    	clawSCG.set(speed);
    }
}

