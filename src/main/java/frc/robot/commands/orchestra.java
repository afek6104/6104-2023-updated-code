// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IneedMusic;

public class orchestra extends CommandBase {
  IneedMusic music = IneedMusic.getInstance();
  private String song;
  /** Creates a new orchestra. */
  public orchestra(String song) {
    this.song = song;
    addRequirements(music);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println(song);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    music.setSong(song);
    music.orchestraStart();
    System.out.println(music.orchestraCheck());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
