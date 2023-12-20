package frc.robot.commands.ElevatorCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.subsystems.Elevator;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class openElevator extends InstantCommand {
  private Elevator elevator = Elevator.getInstance();
  public openElevator() {
    addRequirements(elevator);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    elevator.manualElevator(Constants.Elevator.openElevator);
    Timer.delay(1.35);
    elevator.stopMotors();
  }
}