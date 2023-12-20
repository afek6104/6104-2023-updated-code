package frc.robot.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.Elevator;

public class resetEncoders extends CommandBase {
  private Elevator elevator = Elevator.getInstance();
  private ArmSubsystem arm = ArmSubsystem.getInstance();
  private Claw claw = Claw.getInstance();
  private DrivetrainSubsystem drivetrain = DrivetrainSubsystem.getInstance();

  /** Creates a new resetAllEncoders. */
  public resetEncoders() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    claw.resetClawPosition();
    arm.resetArmPosition();
    elevator.resetElevatorPosition();
    drivetrain.resetEncoders();
  }
  @Override
  public boolean isFinished() {
    return true;
  }
}
