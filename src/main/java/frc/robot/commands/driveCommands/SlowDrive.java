package frc.robot.commands.driveCommands;

import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/** An example command that uses an example subsystem. */
public class SlowDrive extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final CommandXboxController driver;
  private double leftY;
  private double leftX;
  private DrivetrainSubsystem drivetrain = DrivetrainSubsystem.getInstance();
  /**
   * Creates a slowdrive command.
   *
   * @param subsystem The subsystem used by this command.
   */
  public SlowDrive(CommandXboxController driver) {
    this.driver = driver;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftY = driver.getLeftY()/5;
    leftX = driver.getRightX()/5.5;

    // System.out.println("Starting SlowDrive + ofir is gay");

    drivetrain.runLeftSide(leftY + leftX);
    drivetrain.runRightSide(leftY - leftX);

    // drivetrainSubsystem.arcadeDrive(rightX, leftY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}