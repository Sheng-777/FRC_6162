package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSubSystem extends SubsystemBase{
    private final CANSparkMax topShooter = new CANSparkMax(5,MotorType.kBrushed);
    private final CANSparkMax bottomShooter = new CANSparkMax(6,MotorType.kBrushed); 

    public ShootSubSystem(){
        topShooter.setInverted(true);
        bottomShooter.setInverted(true);
    }

    // start commands
    public void shoot(double speed){
        topShooter.set(speed);
        bottomShooter.set(speed);
    }
}
