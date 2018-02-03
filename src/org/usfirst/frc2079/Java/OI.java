package org.usfirst.frc2079.Java;

import org.usfirst.frc2079.Java.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Joystick leftJoystick;
	public JoystickButton clawIntake;
	public JoystickButton clawEject;
	public JoystickButton clawDeployF;
	public JoystickButton clawDeployB;
	public JoystickButton clawFlat;
	public JoystickButton clawDown;
	public JoystickButton armUp;
	public JoystickButton armDown;
	public JoystickButton climb;
	public Joystick manipJoystick;
	public Joystick m_xboxController;

	public OI() {
		m_xboxController = new Joystick(1);
		manipJoystick = new Joystick(2);
		//Claw controls
			clawIntake = new JoystickButton(manipJoystick, 1);
			clawIntake.whileHeld(new CubeClawControl(1.0));
		
			clawEject = new JoystickButton(manipJoystick, 2);
			clawEject.whileHeld(new CubeClawControl(-1.0));
		
			clawDeployF = new JoystickButton(manipJoystick,3);
			clawDeployF.whenPressed(new DeployClaw('f'));
			
			clawDeployB = new JoystickButton(manipJoystick,4);
			clawDeployB.whenPressed(new DeployClaw('b'));
			
			clawFlat = new JoystickButton(manipJoystick, 10);
			clawFlat.whenPressed(new TiltClaw('u'));
		
			clawDown = new JoystickButton(manipJoystick, 11);
			clawDown.whenPressed(new TiltClaw('d'));
			
		//Lifting/Climbing Controls
			armUp = new JoystickButton(manipJoystick,5);
			armUp.whenPressed(new MoveArm('u'));
			
			climb = new JoystickButton(manipJoystick,6);
			climb.whenPressed(new Climb());

		SmartDashboard.putData("DriveToLine", new DriveToLine());
		SmartDashboard.putData("DriveWithJoysticks", new DriveWithJoysticks());
		SmartDashboard.putData("ClawUp", new TiltClaw('u'));
		SmartDashboard.putData("ClawDown", new TiltClaw('d'));
		SmartDashboard.putData("DeployClawF", new DeployClaw('f'));
		SmartDashboard.putData("DeployClawB", new DeployClaw('b'));
		SmartDashboard.putData("ClawIntake", new CubeClawControl(1.0));
		SmartDashboard.putData("ClawEject", new CubeClawControl(-1.0));
		SmartDashboard.putData("ArmUp", new MoveArm('u'));
		SmartDashboard.putData("Winch", new ControlWinch());
		SmartDashboard.putData("Climb", new Climb());
		
		
		
	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getmanipJoystick() {
		return manipJoystick;
	}
}
