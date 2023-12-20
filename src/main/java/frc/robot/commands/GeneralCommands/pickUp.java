// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.GeneralCommands;

import edu.wpi.first.wpilibj.Timer;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.Elevator;

public class pickUp extends CommandBase {
  private ArmSubsystem arm = ArmSubsystem.getInstance();
  private Elevator elevator = Elevator.getInstance();
  Timer globalTimer = RobotContainer.getTimerInstance();
  private boolean isFinished;
  double value;
  /** Creates a new pickUp. */
  public pickUp( double value) {
    addRequirements(arm);
    globalTimer.reset();
    globalTimer.stop();
    this.value = value;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    globalTimer.start();
  }
  
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    arm.setPosition(Constants.Arm.Positions.pickUpStage);
    elevator.manualElevator(value);
    if(globalTimer.get()>1)
    {
    elevator.stopMotors();
    isFinished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
