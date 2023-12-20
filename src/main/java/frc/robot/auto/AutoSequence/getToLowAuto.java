// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.auto.AutoSequence;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.auto.resetEncoders;
import frc.robot.commands.ArmCommands.SetArmPos;
import frc.robot.commands.ArmCommands.rest;
import frc.robot.commands.ClawCommads.eat;
import frc.robot.commands.ClawCommads.spit;
import frc.robot.commands.ElevatorCommands.closeElevator;
import frc.robot.commands.driveCommands.crossLine;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class getToLowAuto extends SequentialCommandGroup {
  /** Creates a new getToHigh. */
  public getToLowAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new resetEncoders(),
    new eat(),
    new closeElevator(),
    new SetArmPos(9000 ,  Constants.Elevator.openElevator),
    new spit(),
    new rest( Constants.Elevator.closeElevator),
    new crossLine());
  }
}