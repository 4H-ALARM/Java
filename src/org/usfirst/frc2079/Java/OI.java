package org.usfirst.frc2079.Java;

import org.usfirst.frc2079.Java.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
	public Joystick leftJoystick;
	public JoystickButton clawIntake;
	public JoystickButton clawEject;
	public JoystickButton clawDeploy;
	public JoystickButton clawFlat;
	public JoystickButton clawDown;
	public JoystickButton armUp;
	public JoystickButton armDown;
	public JoystickButton climb;
	public Joystick manipJoystick;
	public Joystick driveJoystickL;
	public Joystick driveJoystickR;

	public OI() {
		driveJoystickL = new Joystick(0);
		driveJoystickR = new Joystick(1);
		manipJoystick = new Joystick(2);
		// Claw controls
		clawIntake = new JoystickButton(manipJoystick, 1);
		clawIntake.whileHeld(new CubeClawControl(1.0)); // While trigger is held
														// wheels spin inward

		clawEject = new JoystickButton(manipJoystick, 2);
		clawEject.whileHeld(new CubeClawControl(-1.0)); // While button 2 is
														// held wheels spin
														// outward

		clawDeploy = new JoystickButton(manipJoystick, 4);
		clawDeploy.toggleWhenPressed(new DeployClaw()); // When button 3 is
														// pressed claw extends

		clawFlat = new JoystickButton(manipJoystick, 5);
		clawFlat.whileHeld(new TiltClaw('u')); // When button 10 is pressed claw
												// flattens

		clawDown = new JoystickButton(manipJoystick, 3);
		clawDown.whileHeld(new TiltClaw('d')); // When button 11 is pressed claw
												// tilts down

		// Lifting/Climbing Controls
		climb = new JoystickButton(manipJoystick, 11);
		climb.whileHeld(new ControlWinch()); // When button 6 is pressed
												// cylinder retracts and winch
												// motor spins

		armUp = new JoystickButton(manipJoystick, 9);
		armUp.toggleWhenPressed(new MoveArm()); // When button 5 is pressed
												// climbing arm swings up

		// Puts commands into SmartDashboard
		SmartDashboard.putData("DriveToLine", new DriveToLine());
		SmartDashboard.putData("DriveWithJoysticks", new DriveWithJoysticks());
		SmartDashboard.putData("ClawUp", new TiltClaw('u'));
		SmartDashboard.putData("ClawDown", new TiltClaw('d'));
		SmartDashboard.putData("DeployClawF", new DeployClaw());
		SmartDashboard.putData("ClawIntake", new CubeClawControl(1.0));
		SmartDashboard.putData("ClawEject", new CubeClawControl(-1.0));
		SmartDashboard.putData("ArmUp", new MoveArm());
		SmartDashboard.putData("Winch", new ControlWinch());

		/*
		 * @SuppressWarning("FBI") protected static void deleteHerobrine(){
		 * minecraft.delete("herobrine") }
		 */

	}

	public Joystick getLeftJoystick() {
		return leftJoystick;
	}

	public Joystick getmanipJoystick() {
		return manipJoystick;
	}
}
