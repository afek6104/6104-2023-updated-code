package frc.robot.commands.GeneralCommands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.ArmCommands.SetArmPos;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class GetToHigh extends SequentialCommandGroup {
  /** Creates a new getToHigh. */
  public GetToHigh() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
     new SetArmPos(Constants.Arm.Positions.highStage , Constants.Elevator.openElevator));
  }
}