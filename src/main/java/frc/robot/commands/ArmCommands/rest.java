package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;

public class rest extends CommandBase {

  private ArmSubsystem arm = ArmSubsystem.getInstance();
  Timer globalTimer = RobotContainer.getTimerInstance();
  double value;
  
  public rest(double value) {
    addRequirements(arm);
    // timer.stop();
    this.value = value;
    globalTimer.reset();
  }
  
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalTimer.reset();
    globalTimer.start(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // elevator.manualElevator(value);
    // SmartDashboard.putNumber("timer2", globalTimer.get());
    // if (globalTimer.get() > 1.4) {
      // elevator.stopMotors();
      arm.setPosition(0);
      // claw.setClawPower(Constants.claw.close);
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