package frc.robot;

import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {

    public static class Joysticks {
        public final static int driverPort = 0;
        public final static int operatorPort = 1;
    }

    public static class Arm {
        public final static double convertTicks2degreesConstant = 426.666666;
        public static class ID {
            public final static int rightArmID = 15;
            public final static int leftArmID = 12;
        }

        public static class softlimits{
            public static final double rightfwdsoftlimit = 55_000;
            public static final double rightReversesoftlimit = -10_000;
            public static final double leftfwdsoftlimit = 55_000;
            public static final double leftReversesoftlimit = -10_000;
        }

        public static class PIDValues {
            public static final double rightArmMotorKpValue= 0.08;
            public static final double rightArmMotorKiValue = 0;
            public static final double rightArmMotorKdValue= 26;
            public static final double rightArmMotorKfValue = 0;
            public static final double leftArmMotorKpValue = rightArmMotorKpValue;
            public static final double leftArmMotorKiValue = 0;
            public static final double leftArmMotorKdValue= rightArmMotorKdValue; 
            public static final double leftArmMotorKfValue = 0;
        }
        
        public static class Positions{
            public final static double highStage = 42_200;
            public final static double midStage = 32_000;
            public final static double HumanStage = 41_500;
            public final static double pickUpStage = 13_500;
            public final static double restStage = 0;
            public final static double DstFromGamePiece = 254_879;
        }
    }
// the elevator class contains other classes with all of the elevator's needed constants 
    public static class Elevator{

      // this class contains the pid values of the motors

        public static class PIDValues{
            public static final double elevatorkp  = 0.08;
            public static final double elevatorki = 0;
            public static final double elevatorkd =  10;
            public static final double elevatorkf = -0.2;
        }
        // this class contains the elevator motor's id's
        public static class ID{
            public static final int ElevatorID = 14; 
        }

        public static final double openElevator = -0.8;
        public static final double closeElevator = 0.8;
        
    }
// the elevator class contains other classes with all of the claw's needed constants 
public static class claw {
    // pid values u dumbass
        public static class PIDValues{
            public static final double clawkp = 0.22;
            public static final double clawki = 0;
            public static final double clawkd = 10;
            public static final double clawkf = 0;
        }
        public static class ID {
            public final static int ClawID = 3;
        }
        public static class Positions{
            public final static double openClawPos= -7500;
            public final static double closeClawPos= 0;
        }

        public final static double open = 0.2;
        public final static double close = -0.25;
    }
  
    public static final class DriveTrainConstants {

    public static final double rightTicksConvertor = 243.102778;
    public static final double leftTicksConvertor = 283.876389;

    public static final double oneDegreeInTicks = 243.102778;

        public static final class pid {
    
        public static final double m_rightKpValue = 0.03;
        public static final double m_rightKdValue = 20;
        public static final double s_rightKpValue = m_rightKpValue;
        public static final double s_rightKdValue = m_rightKdValue;

        public static final double m_leftKpValue = 0.03;
        public static final double m_leftKdValue = 20;
        public static final double s_leftKpValue = m_leftKpValue;
        public static final double s_leftKdValue = m_leftKdValue;
        }

        public static final double ksVolts = 0.11679;
        public static final double kvVoltSecondsPerMeter = 2.817;
        public static final double kaVoltSecondsSquaredPerMeter = 0.27248;
        public static final double kPDriveVel = 0.45196;

        public static class ID {
            public static final int masterRight = 16;
            public static final int masterLeft = 13;
            public static final int slaveRight = 1;
            public static final int slaveLeft = 2;
            public static final int masterRightButShimi = 3;
            public static final int masterLeftButShimi = 9;
            public static final int slaveRightButShimi = 6;
            public static final int slaveLeftButShimi = 10;
        }

        public static final double gearRatio = 12.5;
        public static final double wheelDiameter = 6; // inches
        public static final double kTrackWidthMeters = Units.inchesToMeters(26.9);
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackWidthMeters);
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;
        public static final double kGearRatio = 12.5;
        public static final double kWheelRadiusInches = 3;
        public static final double kLinearDistanceConversionFactor = (Units.inchesToMeters(1 / (kGearRatio * 2 * Math.PI * Units.inchesToMeters(kWheelRadiusInches)) * 10));
    }

    public static final class music{

        public static final int musicTone = 1500;

    }
}
//FIX: hi