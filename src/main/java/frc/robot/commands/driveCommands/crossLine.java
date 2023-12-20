package frc.robot.commands.driveCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class crossLine extends CommandBase {
  private DrivetrainSubsystem drivetrainSubsystem = DrivetrainSubsystem.getInstance();
  /** Creates a new crossLine. */
  public crossLine() {
    addRequirements(drivetrainSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*CHANGE TO POSITION LATER */
    drivetrainSubsystem.runLeftSide(0.4);
    drivetrainSubsystem.runRightSide(0.4);
    Timer.delay(3);
    // drivetrainSubsystem.rightAuto(position);
    // drivetrainSubsystem.leftAuto(position);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrainSubsystem.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}