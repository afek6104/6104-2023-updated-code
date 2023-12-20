package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class manualArmControl extends CommandBase {

    private ArmSubsystem arm = ArmSubsystem.getInstance();
    double speed;
/**
 *  creates a new manual control command of the arm subsystem
 */
    public manualArmControl(double speed) {
        this.speed = speed;
        addRequirements(arm);
    }

    // Called once when the command is activated
    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        arm.manualPowerToArm(speed);

    }

    @Override
    public void end(boolean interrupted) {
        arm.stopMotors();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}