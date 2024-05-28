package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootSubSystem extends SubsystemBase{
    private final CANSparkMax topShooter = new CANSparkMax(6,MotorType.kBrushed);
    private final CANSparkMax bottomShooter = new CANSparkMax(5,MotorType.kBrushed);
    

    public ShootSubSystem(){
        topShooter.setInverted(false);
        bottomShooter.setInverted(false);
    }

    // start commands
    public void shoot(double speed, double hold){
        if (speed != 0){
            topShooter.set(speed);
            bottomShooter.set(speed);
        }
        else if (speed == 0){
            if (hold == 1){
                topShooter.set(-1);
                bottomShooter.set(0);
            }

            else{
                if (topShooter.get() != 0 || bottomShooter.get() != 0){
                    topShooter.set(0);
                    bottomShooter.set(0);
                }
                
            }
        }

        
        
    }
}
