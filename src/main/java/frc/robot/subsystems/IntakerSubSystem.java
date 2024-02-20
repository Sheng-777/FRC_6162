package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.Robot;


public class IntakerSubSystem extends SubsystemBase{
    public static final double intakerSpeed = 0.5;
    private WPI_TalonSRX topIntakeMotor = new WPI_TalonSRX(05);
    private WPI_TalonSRX bottomIntakeMotor = new WPI_TalonSRX(06);

    @Override
    public void periodic(){
        // called once per scheduler run
    }

    @Override
    public void simulationPeriodic(){
        // clled once in per scheduler in simulation
    }

    public void start(){
        
    }

    private void startIn() {
        topIntakeMotor.set(intakerSpeed);
        bottomIntakeMotor.set(-intakerSpeed);
    }

    private void startOut() {
        topIntakeMotor.set(-intakerSpeed);
        bottomIntakeMotor.set(intakerSpeed);
    }

    public void stop() {
        topIntakeMotor.set(0.0);
        bottomIntakeMotor.set(0.0);
    }


}
