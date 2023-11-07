package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    private final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(01);
    private final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(02);
    private final WPI_TalonSRX backLeftMotor = new WPI_TalonSRX(03);
    private final WPI_TalonSRX backRightMotor = new WPI_TalonSRX(04);    

    private final MecanumDrive robotDrive = new MecanumDrive(frontLeftMotor, backLeftMotor, frontRightMotor, backRightMotor);

    public DriveSubsystem(){
        frontRightMotor.setInverted(true);
        backRightMotor.setInverted(true);
    }

    // drive commands
    public void drive(double x_speed, double y_speed, double z_rotation){
        robotDrive.driveCartesian(x_speed, y_speed, z_rotation);
    }
}
