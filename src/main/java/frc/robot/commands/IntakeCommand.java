package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakerSubSystem;


public class IntakeCommand extends CommandBase{
    private final IntakerSubSystem intakerSubsystem;
    public IntakeCommand(IntakerSubSystem aintakerSubSystem){
        intakerSubsystem = aintakerSubSystem;
        addRequirements(intakerSubsystem);
    }

    @Override
    public void execute(){
        intakerSubsystem.start();
    }

    @Override
    public void end(boolean interrupted){
        intakerSubsystem.stop();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}
