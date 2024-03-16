package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Ultrasonic;
import frc.robot.Robot;


public class IntakerSubSystem extends SubsystemBase{
    private CANSparkMax topIntakeMotor = new CANSparkMax(7, MotorType.kBrushed);
    private CANSparkMax bottomIntakeMotor = new CANSparkMax(8, MotorType.kBrushed);

    @Override
    public void periodic(){
        // called once per scheduler run
    }

    @Override
    public void simulationPeriodic(){
        // clled once in per scheduler in simulation
    }

    public void start(boolean intakeActivate){
        if (intakeActivate){
            topIntakeMotor.set(1);
            bottomIntakeMotor.set(1);
        }
        else{
            topIntakeMotor.set(0);
            bottomIntakeMotor.set(0);
        }
    }

    
}
