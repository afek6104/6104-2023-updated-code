package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.Claw;

public class pickUpAuto extends CommandBase {
  private ArmSubsystem arm = ArmSubsystem.getInstance();
  private Elevator elevator = Elevator.getInstance();
  private Claw claw = Claw.getInstance();
  /** Creates a new command to get the arm and the elevatorto the pickup position  */
  public pickUpAuto() {
    addRequirements(arm);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.setPosition(Constants.Arm.Positions.pickUpStage);
    elevator.manualElevator(Constants.Elevator.openElevator);
    Timer.delay(0.3);
    claw.setClawPower(Constants.claw.close);
    Timer.delay(0.2);
  }
}
