package frc.robot.commands.ElevatorCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;

public class stopElevator extends CommandBase {
 private Elevator elevator = Elevator.getInstance();
  /** Creates a new stopElevator. */
  public stopElevator() {
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    elevator.stopMotors();
  }
}