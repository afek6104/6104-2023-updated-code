package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
/**
 * Claw subsystem and stuff
 */
public class Claw extends SubsystemBase {

    private TalonFX clawMotor; // the clawMotor object 
    private static Claw claw = null; // the instance :)
    
/*
 * the claw constructor here we define every motior property we want to define
 */
     public Claw() {

    clawMotor = new TalonFX(Constants.claw.ID.ClawID); // here we give the motor an id (the one we see on phoenix tuner)
    /*
     * here we config all of the wanted motor values, defaults and limits
     */
    clawMotor.configFactoryDefault();
    clawMotor.config_kP(0, Constants.claw.PIDValues.clawkp);
    clawMotor.config_kI(0, Constants.claw.PIDValues.clawki);
    clawMotor.config_kD(0, Constants.claw.PIDValues.clawkd);
    clawMotor.config_kF(0, Constants.claw.PIDValues.clawkf);
    clawMotor.setSensorPhase(false);
    clawMotor.setNeutralMode(NeutralMode.Coast); // now the motor is on coast and spins freely

  }
/*
 * the periodic function just repeats always its a loop where we can define updating variables and use it
 * to debug things with printing
 */
    @Override
    public void periodic() {

    }
/**
 * give the claw motor a value with PercentOutPut by using the constructor we can also give the motor 
 * different values in defferent commands
 */
    public void setClawPower (double power){
        clawMotor.set(TalonFXControlMode.PercentOutput, power);
    }
/**
 * defines the position the claw needs to get to to open up :)
 */
    public void openClaw() {
        clawMotor.set(ControlMode.Position, Constants.claw.Positions.openClawPos);

    }
/**
 * defines the position the claw needs to get to to close up :)
 */
    public void CloseClaw(){
        clawMotor.set(ControlMode.Position, Constants.claw.Positions.closeClawPos);

    }
/**
 * instantly sets the claw motor's positon to zero
 */
    public void resetClawPosition() {
        clawMotor.setSelectedSensorPosition(0);
      }
/**
 * stop the claw motor's :)
 */
    public void stopclawMotors() {
        clawMotor.set(TalonFXControlMode.PercentOutput, 0);
    }
/**
 * the instance of the claw we define this so we can use the methods (the blue ones) in other classes 
 * and commands we can call this method by writing Claw claw = claw.getinstance();
 * @return claw with all the methods created in it
 */
    public static Claw getInstance() {
        if (claw == null) {
            claw = new Claw();
        }
        return claw;
    }
}