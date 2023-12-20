package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ArmSubsystem;

public class ResetArmEncoder extends InstantCommand {
  private ArmSubsystem arm = ArmSubsystem.getInstance();
  public ResetArmEncoder() {
    addRequirements(arm);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.resetArmPosition();

  }
}
