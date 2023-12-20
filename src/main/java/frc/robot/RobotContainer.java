package frc.robot;



import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.auto.resetEncoders;
import frc.robot.auto.AutoSequence.getToHighAuto;
import frc.robot.auto.AutoSequence.getToLowAuto;
import frc.robot.auto.AutoSequence.getToMidAuto;
import frc.robot.commands.orchestra;
import frc.robot.commands.ArmCommands.ResetArmEncoder;
import frc.robot.commands.ArmCommands.SetArmPos;
import frc.robot.commands.ArmCommands.manualArmControl;
import frc.robot.commands.ArmCommands.rest;
import frc.robot.commands.ClawCommads.clawControl;
import frc.robot.commands.ClawCommads.stopIntake;
import frc.robot.commands.ElevatorCommands.manualClose;
import frc.robot.commands.ElevatorCommands.manualOpen;
import frc.robot.commands.driveCommands.DriveWithJoystickCommand;
import frc.robot.commands.driveCommands.SlowDrive;
import frc.robot.commands.driveCommands.stopDrive;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS4Controller;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  static Timer timer = new Timer();
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem drivetrainSubsystem = DrivetrainSubsystem.getInstance();
  public static CommandPS4Controller operator = new CommandPS4Controller(Constants.Joysticks.operatorPort);
  public static CommandXboxController driver = new CommandXboxController(Constants.Joysticks.driverPort);
  private final DriveWithJoystickCommand driveWithJoystickCommand = new DriveWithJoystickCommand(driver);
  public getToHighAuto highAuto = new getToHighAuto();
  public getToMidAuto midAuto = new getToMidAuto();
  public getToLowAuto lowAuto = new getToLowAuto();
  public resetEncoders resetEncodersAuto = new resetEncoders();
  public orchestra orchestra = new orchestra("star wars.chrp");
  public static SendableChooser<Command> autoChooser = new SendableChooser<>();
  
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    autoChooser.addOption("getToHigh", highAuto); // adds the get to high option to the shuffleboard 
    autoChooser.addOption("getToMid", midAuto); // adds the get to mid option to the shuffleboard 
    autoChooser.addOption("getToLow", lowAuto); // adds the get to low option to the shuffleboard 
    autoChooser.setDefaultOption("do nothing", resetEncodersAuto); // adds the reset encoders option to the shuffleboard 
    Shuffleboard.getTab("Autonomous shel afek").add(autoChooser);

    configureButtonBindings();
    /*
     * driver part of the controller bindings
     */
    drivetrainSubsystem.setDefaultCommand(driveWithJoystickCommand);
    driver.rightBumper().whileTrue(new SlowDrive(driver)); // activate the slow drive command
    driver.leftBumper().whileTrue(new stopDrive());
    /*
     * the operator part of the controller bindings
     */
    driver.povLeft().toggleOnTrue(new clawControl(0.2)); 
    driver.povRight().onTrue(new clawControl(-0.25));
    driver.rightTrigger().whileTrue(new ResetArmEncoder());
    // driver.a().whileTrue(new orchestra("star wars.chrp"));
    // driver.b().whileTrue(new orchestra("rick roll.chrp"));
    driver.y().onTrue(new SetArmPos(Constants.Arm.Positions.highStage, Constants.Elevator.openElevator));
    driver.x().toggleOnTrue(new SetArmPos(Constants.Arm.Positions.midStage, Constants.Elevator.openElevator));
    driver.b().onTrue(new SetArmPos(Constants.Arm.Positions.HumanStage, Constants.Elevator.openElevator));
    driver.a().onFalse(new SetArmPos(Constants.Arm.Positions.pickUpStage, Constants.Elevator.openElevator));
    driver.back().onTrue(new rest(Constants.Elevator.closeElevator));
    driver.leftStick().whileTrue(new stopIntake());
    driver.leftBumper().whileTrue(new manualClose(0.85));
    driver.rightBumper().whileTrue(new manualOpen(-0.85));
    driver.povUp().whileTrue(new manualArmControl( 0.25));
    driver.povDown().whileTrue(new manualArmControl( -0.25));
  }

  private void configureButtonBindings() {}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */

   public static Timer getTimerInstance() {
    if (timer == null) {
      timer = new Timer();
    }
    return timer;
  }
 public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
 return autoChooser.getSelected();
 }
}