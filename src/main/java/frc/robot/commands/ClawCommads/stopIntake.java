package frc.robot.commands.ClawCommads;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Claw;

public class stopIntake extends CommandBase {

 private Claw claw = Claw.getInstance();
  /**  a Command that stop the claw motor. */
  public stopIntake() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(claw);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    claw.stopclawMotors();
  }
}