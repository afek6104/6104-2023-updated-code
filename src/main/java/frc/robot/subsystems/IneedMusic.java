package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.music.Orchestra;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IneedMusic extends SubsystemBase {
  WPI_TalonFX masterRight;
  WPI_TalonFX masterLeft;
  WPI_TalonFX slaveLeft;
  WPI_TalonFX slaveRight;
  TalonFX rightArmMotor;
  TalonFX leftArmMotor;
  TalonFX clawMotor;
  Orchestra orchestra;

  private static IneedMusic Ineedmusic = null;

/**
 * the drivetrain constructor here we define all of the motor functions
 */
  public IneedMusic() {

    clawMotor = new TalonFX(Constants.claw.ID.ClawID); // here we give the motor an id (the one we see on phoenix tuner)
    rightArmMotor = new TalonFX(Constants.Arm.ID.rightArmID); 
    leftArmMotor = new TalonFX(Constants.Arm.ID.leftArmID); 
    masterRight = new WPI_TalonFX(Constants.DriveTrainConstants.ID.masterRight);
    masterLeft = new WPI_TalonFX(Constants.DriveTrainConstants.ID.masterLeft);
    slaveLeft = new WPI_TalonFX(Constants.DriveTrainConstants.ID.slaveLeft);
    slaveRight = new WPI_TalonFX(Constants.DriveTrainConstants.ID.slaveRight);
 
    orchestra = new Orchestra();
    orchestra.addInstrument(masterRight);
    orchestra.addInstrument(masterLeft);
    orchestra.addInstrument(slaveLeft);
    orchestra.addInstrument(slaveRight);
    orchestra.addInstrument(clawMotor);
    orchestra.addInstrument(rightArmMotor);
    orchestra.addInstrument(leftArmMotor);
    
    masterLeft.set(TalonFXControlMode.MusicTone,Constants.music.musicTone);
    masterRight.set(TalonFXControlMode.MusicTone,Constants.music.musicTone);
    slaveLeft.set(TalonFXControlMode.MusicTone,Constants.music.musicTone);
    slaveRight.set(TalonFXControlMode.MusicTone,Constants.music.musicTone);    
    
    slaveRight.follow(masterRight);
    slaveLeft.follow(masterLeft);

}

    @Override
    public void periodic() {
    
}

public void setSong (String song){
  orchestra.loadMusic(song);
}

public void orchestraStart(){
  orchestra.play();
}

public void orchestraPause(){
  orchestra.pause();
}

public void stopOrchestra(){
  orchestra.stop();
}

public Boolean orchestraCheck(){
  return orchestra.isPlaying();

}

  public static IneedMusic getInstance() {
    if (Ineedmusic == null) {
        Ineedmusic = new IneedMusic();
    }
    return Ineedmusic;
 }
}