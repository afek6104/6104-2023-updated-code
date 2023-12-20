package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class SetArmPos extends CommandBase {
  private ArmSubsystem arm = ArmSubsystem.getInstance();
  private double position;

  Timer globalTimer = RobotContainer.getTimerInstance();
  double value;

  
  public SetArmPos(double position , double value) {
    addRequirements(arm);
    this.position = position;
    this.value = value;
    // timer.stop();
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
   
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arm.setPosition(position);
   
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}