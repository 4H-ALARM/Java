package org.usfirst.frc2079.Java;

import org.usfirst.frc2079.Java.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	private Joystick manipJoystick;
	private Joystick xboxController;

	private JoystickButton clawIntake;
	private JoystickButton clawEject;
	private JoystickButton clawDeploy;
	private JoystickButton clawFlat;
	private JoystickButton clawDown;

	private JoystickButton armUp;
	private JoystickButton armDown;
	private JoystickButton climb;

	private JoystickButton winchOut1;
	private JoystickButton winchOut2;

	private JoystickButton cameraControl;
	private JoystickButton cameraPreset;

	public OI() {
		// Joysticks
		xboxController = new Joystick(3);
		manipJoystick = new Joystick(2);

		// Claw controls
		clawIntake = new JoystickButton(manipJoystick, 1);
		clawIntake.whileHeld(new CubeClawControl(1.0)); // While trigger is held wheels spin inward

		clawEject = new JoystickButton(manipJoystick, 2);
		clawEject.whileHeld(new CubeClawControl(-1.0)); // While button 2 is held wheels spin outward
		clawDeploy = new JoystickButton(manipJoystick, 4);

		clawDeploy.toggleWhenPressed(new DeployClaw()); // When button 3 is pressed claw extends

		clawFlat = new JoystickButton(manipJoystick, 5);
		clawFlat.whileHeld(new TiltClaw(1)); // When button 10 is pressed claw flattens

		clawDown = new JoystickButton(manipJoystick, 3);
		clawDown.whileHeld(new TiltClaw(-1)); // When button 11 is pressed claw tilts down

		// Lifting/Climbing Controls
		climb = new JoystickButton(manipJoystick, 11);
		climb.whileHeld(new ControlWinch(1.0)); // When button 6 is pressed cylinder retracts and winch motor spins

		winchOut1 = new JoystickButton(manipJoystick, 7);
		winchOut2 = new JoystickButton(manipJoystick, 6);

		winchOut2.whileHeld(new ControlWinch(-1));

		armUp = new JoystickButton(manipJoystick, 9);
		armUp.toggleWhenPressed(new MoveArm()); // When button 5 is pressed climbing arm swings up

		// Camera
		cameraControl = new JoystickButton(manipJoystick, 10);
		cameraControl.toggleWhenPressed(new ControlCamera());

		cameraPreset = new JoystickButton(manipJoystick, 12);
		

		// Puts commands into SmartDashboard
		SmartDashboard.putData("DriveToLine", new DriveToLine());
		SmartDashboard.putData("DriveWithJoysticks", new DriveWithJoysticks());
		SmartDashboard.putData("ClawUp", new TiltClaw(1));
		SmartDashboard.putData("ClawDown", new TiltClaw(-1));
		SmartDashboard.putData("DeployClawF", new DeployClaw());
		SmartDashboard.putData("ClawIntake", new CubeClawControl(1.0));
		SmartDashboard.putData("ClawEject", new CubeClawControl(-1.0));
		SmartDashboard.putData("ArmUp", new MoveArm());
		SmartDashboard.putData("Winch", new ControlWinch(1));

		// System.out.print("effective. Power");

	}

	public double getManipAxis(int channel) { // Returns the value of a certain axis on the manipulator joystick
		return manipJoystick.getRawAxis(channel);
	}
	
	public Joystick getDriveJoy() {
		return xboxController;
	}
	
	public boolean reverseWinch() {
		return winchOut1.get();
	}
	
	public boolean cameraPresetPressed() {
		return cameraPreset.get();
	}

}
