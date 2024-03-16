package frc.robot.commands;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakerSubSystem;


public class IntakeCommand extends CommandBase{
    private final IntakerSubSystem intakerSubsystem;
    private final BooleanSupplier s;
    public IntakeCommand(IntakerSubSystem aintakerSubSystem, BooleanSupplier activated){
        intakerSubsystem = aintakerSubSystem;
        addRequirements(intakerSubsystem);
        s = activated;
    }

    @Override
    public void execute(){
        intakerSubsystem.start(s.getAsBoolean());
    }

}
