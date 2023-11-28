package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase{
    private final DriveSubsystem robotDriveSubsystem;
    private final DoubleSupplier x_speed, y_speed, z_rotation, sensitivity;

    public DriveCommand(DriveSubsystem subsystem, DoubleSupplier x, DoubleSupplier y, DoubleSupplier z, DoubleSupplier s){
        robotDriveSubsystem = subsystem;
        x_speed = x;
        y_speed = y;
        z_rotation = z;
        sensitivity = s;
        addRequirements(robotDriveSubsystem);
    }

    @Override
    public void execute(){
        robotDriveSubsystem.drive(x_speed.getAsDouble(), y_speed.getAsDouble(), z_rotation.getAsDouble(),(sensitivity.getAsDouble() + 1) / 2);
    }

    
}
