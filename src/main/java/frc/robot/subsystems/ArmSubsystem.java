package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.music.Orchestra;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
/**
 * yeah its just the arm subsystem :)
 */

public class ArmSubsystem extends SubsystemBase {
  private TalonFX rightArmMotor;// the rightArmMotor
  private TalonFX leftArmMotor; // the leftArmMotor
  Orchestra orchestra; // music and shit
  // private double FXTicks; // a variable (mishtane) that is eqaul to the motor ticks
  // private double FXAngle; // a variable that converts ticks to degrees
  // private double FXRadians; // a variable that converts degrees to radians
  public static ArmSubsystem arm = null; 
/**
 * the constractor of the arm subsystem here we define everything that is related to the arm and its motors
 */
  public ArmSubsystem() {
    rightArmMotor = new TalonFX(Constants.Arm.ID.rightArmID); 
    leftArmMotor = new TalonFX(Constants.Arm.ID.leftArmID); 
    rightArmMotor.clearStickyFaults(); // clears the motor's stickyFaults
    leftArmMotor.clearStickyFaults();
    rightArmMotor.configFactoryDefault(); // reset the motor to default
    leftArmMotor.configFactoryDefault();
    // leftArmMotor.setInverted(TalonFXInvertType.Clockwise); // invert the motor to rotate counterClockwise
    // rightArmMotor.setInverted(TalonFXInvertType.Clockwise); // invert the motor to rotate clockwise
    orchestra = new Orchestra();
    orchestra.loadMusic("lacucaracha.chrp");
    orchestra.addInstrument(leftArmMotor);
    orchestra.addInstrument(rightArmMotor);
/*
 * here we config every value and limit we want to set to the motor
 */
    rightArmMotor.configForwardSoftLimitThreshold(Constants.Arm.softlimits.rightfwdsoftlimit); // this is the forward limit to the right motor
    rightArmMotor.configReverseSoftLimitThreshold(Constants.Arm.softlimits.rightReversesoftlimit); // this is the reverse limit to the right motor
    rightArmMotor.configForwardSoftLimitEnable(true); // here we enable the forward limit 
    rightArmMotor.configReverseSoftLimitEnable(true); // here we enable the reverse limit
    leftArmMotor.configForwardSoftLimitThreshold(Constants.Arm.softlimits.leftfwdsoftlimit);
    leftArmMotor.configReverseSoftLimitThreshold(Constants.Arm.softlimits.leftReversesoftlimit);
    leftArmMotor.configForwardSoftLimitEnable(true);
    leftArmMotor.configReverseSoftLimitEnable(true);
    leftArmMotor.setNeutralMode(NeutralMode.Brake); // sets the motor to brake (the one when its harder to move)
    rightArmMotor.setNeutralMode(NeutralMode.Brake);
    /*
     * the pid values we give the arm motor
     */
    rightArmMotor.config_kP(0, Constants.Arm.PIDValues.rightArmMotorKpValue);
    leftArmMotor.config_kP(0, Constants.Arm.PIDValues.leftArmMotorKpValue);
    rightArmMotor.config_kD(0, Constants.Arm.PIDValues.rightArmMotorKdValue);
    leftArmMotor.config_kD(0, Constants.Arm.PIDValues.leftArmMotorKdValue);

    // rightArmMotor.config_kF(0, (0.0443*sin)+0.0564);
    // leftArmMotor.config_kF(0, (0.0443*sin)+0.0564);
  }
/**
 * the periodic method who runs periodiclly (always) basically a "loop" 
 * you can find more details on {@link CommandSchedular}
 */
  @Override
  public void periodic() {
  
    /*
     * we define all of this variables here because we want them to update always we 
     * can define the other variables who doesent require updating constantly in the constructor
     */
    SmartDashboard.updateValues();
  }
  /**
   * here we tell the arm motor's to get to a certain position by using a constructor we use 
   * the constructor to give the motor's different poition and just one we cna set the position in the
   * command, in the sequential command or in the robotcontainer
  */
  public void setPosition(double position) {
    rightArmMotor.set(TalonFXControlMode.Position, position);
    leftArmMotor.set(TalonFXControlMode.Position, position); 
  }
/**
 * returns the amount of ticks the motor had gotten to 
 * @param ArmTicks a vairable that is equal to the amount of the ticks
 */
  public double getArmPosition() {
    return rightArmMotor.getSelectedSensorPosition();
  }
/**
 * i play music lma
 */
  public void orchestraStart(){
    orchestra.play();
  }

  public void orchestraPause(){
    orchestra.pause();
  }

/**
* gives the arm motor's percentOutput and by using a constructor we can give the motor different values 
*
*/ public void manualPowerToArm(double PercentOutput) {
    rightArmMotor.set(TalonFXControlMode.PercentOutput,PercentOutput);
    leftArmMotor.set(TalonFXControlMode.PercentOutput,-PercentOutput);
  }
   /**
    * instantly resets the ticks of the arm motor's
        */
  public void resetArmPosition() {
    rightArmMotor.setSelectedSensorPosition(0);
    leftArmMotor.setSelectedSensorPosition(0);
  }
/**
 * stops the motors 0_0)
 */
  public void stopMotors() {
    rightArmMotor.set(TalonFXControlMode.PercentOutput,0);
    leftArmMotor.set(TalonFXControlMode.PercentOutput,0);

  }
/**
 * the instance of the arm we define this so we can use the methods (the blue ones) in other classes 
 * and commands we can call this method by writing ArmSubsystem arm = Armsubsystem.getinstance();
 * @return arm with all the methods created
 */
  public static ArmSubsystem getInstance() {
    if (arm == null) {
      arm = new ArmSubsystem();
    }
    return arm;
  }
}