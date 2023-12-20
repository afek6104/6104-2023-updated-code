package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
    
    private TalonSRX ElevatorMotor;
    // For the singelton later on
    private static Elevator elevator = null;
    /**
     * the elevator constructor is where we define all of the motors thingies
     */
    public Elevator() {
        ElevatorMotor = new TalonSRX(Constants.Elevator.ID.ElevatorID);
        ElevatorMotor.configFactoryDefault();
        ElevatorMotor.setNeutralMode(NeutralMode.Brake);
        ElevatorMotor.setInverted(false);
        ElevatorMotor.config_kP(0, Constants.Elevator.PIDValues.elevatorkp);
        ElevatorMotor.config_kD(0, Constants.Elevator.PIDValues.elevatorkd);
    }
    /**
     * :) homo
     */
    @Override
    public void periodic() {
        // System.out.println("Elevator: " + getElevatorPos());
    }
    /**
     * resets the elevatorMotor's position
     */
    public void resetElevatorPosition(){
        ElevatorMotor.setSelectedSensorPosition(0);
        // System.out.println("elevator is reset");
    }

   
    public double getElevatorPos(){
        return ElevatorMotor.getSelectedSensorPosition();
    }
    /**
     * gives negative PercentOutPut to the elevator motor
     * @param po
     */
    // public void closeELE( double po){
    //     ElevatorMotor.set(TalonSRXControlMode.PercentOutput, po);
    // }
    /**
     * gives positive PercentOutPut to the elevator motor
     * @param po
     */
    public void manualElevator( double po){
        ElevatorMotor.set(TalonSRXControlMode.PercentOutput, po);
    }

   
    public void stopMotors() {
        ElevatorMotor.set(TalonSRXControlMode.PercentOutput, 0);
    }
 /**
 * the instance of the elevator we define this so we can use the methods (the blue ones) in other classes 
 * and commands we can call this method by writing Elevator elevator = Elevator.getinstance();
 * @return elevator
 */
    public static Elevator getInstance() {
        if (elevator == null) {
            elevator = new Elevator();
        }
        return elevator;
    }
}