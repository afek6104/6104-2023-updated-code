package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;


import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {
  WPI_TalonFX masterRight;
  WPI_TalonFX masterLeft;
  WPI_TalonFX slaveLeft;
  WPI_TalonFX slaveRight; 

  Orchestra orchestra;

 private double m_rightTicks;
 private double m_leftTicks;

  public static DrivetrainSubsystem instance = null;
  private static DrivetrainSubsystem driveTrain = null;
  public final static Gyro navX = new AHRS(SPI.Port.kMXP);

/**
 * the drivetrain constructor here we define all of the motor functions
 */
  public DrivetrainSubsystem() {

    
    masterRight = new WPI_TalonFX(Constants.DriveTrainConstants.ID.masterRight);
    masterLeft = new WPI_TalonFX(Constants.DriveTrainConstants.ID.masterLeft);
    slaveLeft = new WPI_TalonFX(Constants.DriveTrainConstants.ID.slaveLeft);
    slaveRight = new WPI_TalonFX(Constants.DriveTrainConstants.ID.slaveRight);
    
    masterRight.config_kP(0, Constants.DriveTrainConstants.pid.m_rightKpValue);
    masterRight.config_kD(0, Constants.DriveTrainConstants.pid.m_rightKdValue);
    slaveRight.config_kP(0,Constants.DriveTrainConstants.pid.s_rightKpValue);
    slaveRight.config_kD(0, Constants.DriveTrainConstants.pid.s_rightKdValue);
    masterRight.configMotionAcceleration(1000);
    masterRight.configMotionCruiseVelocity(10_000);
    slaveRight.configMotionAcceleration(1000);
    slaveRight.configMotionCruiseVelocity(10_000);
    
    orchestra = new Orchestra();
    orchestra.loadMusic("star wars.chrp");
    orchestra.addInstrument(masterRight);
    orchestra.addInstrument(masterLeft);
    orchestra.addInstrument(slaveLeft);
    orchestra.addInstrument(slaveRight);

    masterLeft.config_kP(0, Constants.DriveTrainConstants.pid.m_leftKpValue);
    masterLeft.config_kD(0, Constants.DriveTrainConstants.pid.m_leftKdValue);
    slaveLeft.config_kP(0, Constants.DriveTrainConstants.pid.s_leftKpValue);
    slaveLeft.config_kD(0, Constants.DriveTrainConstants.pid.s_leftKdValue);
    masterLeft.configMotionAcceleration(1000);
    masterLeft.configMotionCruiseVelocity(10_000);
    slaveRight.configMotionAcceleration(1000);
    slaveRight.configMotionCruiseVelocity(10_000);

    navX.reset();
    navX.calibrate();
    resetEncoders();
    masterRight.setInverted(true);
    slaveRight.setInverted(true);
    masterLeft.setInverted(false);
    slaveLeft.setInverted(false);
    
    masterLeft.setNeutralMode(NeutralMode.Brake);
    masterRight.setNeutralMode(NeutralMode.Brake);
    slaveLeft.setNeutralMode(NeutralMode.Brake);
    slaveRight.setNeutralMode(NeutralMode.Brake);

    masterLeft.set(TalonFXControlMode.MusicTone,10000);
    masterRight.set(TalonFXControlMode.MusicTone,10000);
    slaveLeft.set(TalonFXControlMode.MusicTone,10000);
    slaveRight.set(TalonFXControlMode.MusicTone,10000);    
    
    slaveRight.follow(masterRight);
    slaveLeft.follow(masterLeft);

}

    @Override
    public void periodic() {
    // System.out.println(navX.getRotation2d().getDegrees());
    // System.out.println("oved");
      m_rightTicks = masterRight.getSelectedSensorPosition();
      m_leftTicks = masterLeft.getSelectedSensorPosition();
      SmartDashboard.putNumber("gyroheading", getHeading());

}
/**
 * this method returns the speed the angle changes
 * @return angle change rate
 */
public double getTurnRate() {
  return -navX.getRate();
}
/**
 * this method gets the direction the robot is heading with degrees
 * @return robot's heading
 */
public static double getHeading() {
  return navX.getRotation2d().getDegrees();
}

public void orchestraStart(){
  orchestra.play();
}

public void orchestraPause(){
  orchestra.pause();
}

public void stoporchestra(){
  orchestra.stop();
}

/**
 * 
 * @return the master right motor's in degress 
 */
public double convertRightTicksToAngle() {
 return m_rightTicks / Constants.DriveTrainConstants.rightTicksConvertor;
}
/**
 * the master left motor's in degrees
 * @return
 */
public double converLeftTicksToAngle(){
 return m_leftTicks/ Constants.DriveTrainConstants.leftTicksConvertor;
}
/**
 * this method gives the robot a position to get to with multiplying ticks in wanted degrees
 * @param angle
 */
public void turnRobot(double angle) {
  masterRight.set(TalonFXControlMode.Position, angle * Constants.DriveTrainConstants.oneDegreeInTicks);
  masterLeft.set(TalonFXControlMode.Position, -angle * Constants.DriveTrainConstants.oneDegreeInTicks);
}

public void stopMotors() {
  masterRight.stopMotor();
  masterLeft.stopMotor();
}

  /**
   * resets the drivetrain encoders
   */

  public void resetEncoders() {
    masterRight.setSelectedSensorPosition(0);
    masterLeft.setSelectedSensorPosition(0);
  }
 
  public void arcadeDrive(double fwd, double rot) {
    // differentialDrive.arcadeDrive(fwd, rot);
  }
/**
 * controls the right side of the chassis 
 * @param speed
 */
  public void runRightSide(double speed) {
    masterRight.set(speed);
  }
/**
 * controls the left side of the chassis
 * @param speed
 */
  public void runLeftSide(double speed) {
    masterLeft.set(speed);
  }

  public void rightAuto(double position){
    masterRight.set(TalonFXControlMode.Position, position);
  }

  public void leftAuto(double position){
    masterLeft.set(TalonFXControlMode.Position,position);
  }
  
  /**
   * return right sensor position in ticks
   * @return master right position
   */
  public double getRightEncoderPosition() {
    return -masterRight.getSelectedSensorPosition();
  }
  /**
   * return left sensor position in ticks
   * @return master lest position
   */
  public double getLeftEncoderPosition() {
    return masterLeft.getSelectedSensorPosition();
  }
/**
 * sets the drive motors to break mode 
 */
  public void setBreakMode(){
    masterLeft.setNeutralMode(NeutralMode.Brake);
    masterRight.setNeutralMode(NeutralMode.Brake);
    slaveLeft.setNeutralMode(NeutralMode.Brake);
    slaveRight.setNeutralMode(NeutralMode.Brake);
  }
  /**
   * return master right velocity in ticks
   * @return master right velocity in ticks
   */
  public double getRightEncoderVelocity() {
    return -masterRight.getSelectedSensorVelocity();
  }
  /**
   * return master left velocity in ticks
   * @return master left velocity in ticks
   */
  public double getLeftEncoderVelocity() {
    return masterLeft.getSelectedSensorVelocity();
  }

 /**
 * the instance of the drivetrain we define this so we can use the methods (the blue ones) in other classes 
 * and commands we can call this method by writing DrivetrainSubsystem drivetrain = DrivetrainSubsystem.getinstance();
 * @return driveTrain
 */
  public static DrivetrainSubsystem getInstance() {
    if (driveTrain == null) {
        driveTrain = new DrivetrainSubsystem();
    }
    return driveTrain;
 }
}