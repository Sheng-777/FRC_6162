package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootSubSystem;

public class ShootCommand extends CommandBase{
    private final ShootSubSystem robotShootSubSystem;
    private final DoubleSupplier speed;

    public ShootCommand(ShootSubSystem subsystem, DoubleSupplier s){
        robotShootSubSystem = subsystem;
        speed = s;
        addRequirements(robotShootSubSystem);
    }

    @Override
    public void execute(){
        robotShootSubSystem.shoot(speed.getAsDouble());
    }


}
