package frc.robot.commands.driveCommands;

import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

/** An example command that uses an example subsystem. */
public class DriveWithJoystickCommand extends CommandBase {
  @SuppressWarnings({ "PMD.UnusedPrivateField", "PMD.SingularField" })
  private final DrivetrainSubsystem drivetrain = DrivetrainSubsystem.getInstance();
  private final CommandXboxController driver;
  private double leftY;
  private double leftX;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveWithJoystickCommand(CommandXboxController driver) {
    this.driver = driver;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Starting joystick drive command ");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    leftY = driver.getLeftX()/1.2;
    leftX = driver.getLeftY()/2.5;

    drivetrain.runLeftSide(leftY + leftX);
    drivetrain.runRightSide(leftY - leftX);

    // drivetrainSubsystem.arcadeDrive(rightX, leftY);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // drivetrainSubsystem.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}