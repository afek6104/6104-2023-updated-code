package frc.robot.commands.driveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class turnRobot extends CommandBase {
  double angle;
  private DrivetrainSubsystem drivetrain = DrivetrainSubsystem.getInstance();
  /** Creates a new turnRobot. */
  public turnRobot(double angle) {
    addRequirements(drivetrain);
    this.angle= angle;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.turnRobot(angle);
  }
}