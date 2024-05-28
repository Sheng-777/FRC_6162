// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakerSubSystem;
import frc.robot.subsystems.ShootSubSystem;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  //private final IntakerSubSystem intakerSubSystem = new IntakerSubSystem();
  public final static DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final static ShootSubSystem shootSubSystem = new ShootSubSystem();
  private final static IntakerSubSystem intakerSubSystem = new IntakerSubSystem();


  private final GenericHID controller = new GenericHID(0);


  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

      
      public static void autoSpawnMid(){
        double restTime = 0.55;
        double initialTime = 0.1;
        double spinTime = 0.23;
        double stallTime = 8;
        double backwardTime = 2.3;
        double forwardTime = 1.62;
        double shootTime = 0.5;

        if (Robot.autoTimer.get() < initialTime){
          shootSubSystem.shoot(0, 0);

      }
      else if (Robot.autoTimer.get() < initialTime + spinTime){
        driveSubsystem.drive(0, 0, 0, 1);
      }
      else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + stallTime){
        driveSubsystem.drive(0, 0, 0, 0);
      }
      else if (Robot.autoTimer.get() < initialTime + spinTime + restTime){

      }
    }

      public static void autoSpawnRight(){
        double restTime = 0.55;
        double initialTime = 0.1;
        double spinTime = 0.23;
        double backwardTime = 2.3;
        double forwardTime = 1.6;
        double shootTime = 0.5;
        
        if (Robot.autoTimer.get() < initialTime){
            shootSubSystem.shoot(0, 0);

        }
        else if (Robot.autoTimer.get() < initialTime + spinTime){
          driveSubsystem.drive(0, 0, -0.5, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime){
          driveSubsystem.drive(0, 0, 0, 0);
        }

        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime){
          System.out.println("GOING STRAIGHT");
          driveSubsystem.drive(-0.35, 0, 0, 1);
        }

        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime){
          driveSubsystem.drive(0, 0, 0, 1);

        }

        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime){
          System.out.println("GOING STRAIGHT");
          driveSubsystem.drive(0.35, 0, 0, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime){
          driveSubsystem.drive(0, 0, 0, 1);
        }
        else if (Robot.autoTimer.get()< initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime + shootTime){
          System.out.println("SHOOTING");
          shootSubSystem.shoot(-1, 0);
        }

       // Robot.autoTimer.reset();
      }

      public static void autoSpawnLeft(){
        double restTime = 0.55;
        double initialTime = 0.1;
        double spinTime = 0.4;
        double backwardTime = 2.3;
        double forwardTime = 1.2;
        double forwardTwoTime = 1.6;
        double stallTime = 7.8;
        double shootTime = 1.2;
        
        if (Robot.autoTimer.get() < initialTime){
            shootSubSystem.shoot(0, 0);

        }
        else if (Robot.autoTimer.get() < initialTime + stallTime){
          shootSubSystem.shoot(0, 0);
        }
        else if (Robot.autoTimer.get() < initialTime + stallTime + 0.8){
          shootSubSystem.shoot(0,1);
        }
        else if (Robot.autoTimer.get() < initialTime + stallTime + 0.8 + shootTime){
            shootSubSystem.shoot(-1,0);
        }
        else if (Robot.autoTimer.get() < initialTime + stallTime + 0.8 + shootTime + restTime){
          shootSubSystem.shoot(0, 0);
        }
        else if (Robot.autoTimer.get() < initialTime + stallTime + 0.8 + shootTime + restTime + backwardTime){
          driveSubsystem.drive(-0.5, 0, 0, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + 0.8 + stallTime + shootTime + restTime + backwardTime  + restTime){
          driveSubsystem.drive(0,0,0,0);
        }
        else if (Robot.autoTimer.get() < initialTime + 0.8 + stallTime + shootTime + restTime + backwardTime  + restTime + forwardTwoTime){
          driveSubsystem.drive(0, -0.5, 0, 1);
          //driveSubsystem.drive(0, -0.5, 0, 1);
        }
        else{
          shootSubSystem.shoot(0, 0);
          driveSubsystem.drive(0, 0, 0, 1);
        }
        /* 
        else if (Robot.autoTimer.get() < initialTime + spinTime){
          driveSubsystem.drive(0, 0, 0, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime){
          driveSubsystem.drive(0, 0, 0, 0);
        }

        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime){
          System.out.println("GOING STRAIGHT");
          driveSubsystem.drive(-0.35, 0, 0, 1);
        }

        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime){
          driveSubsystem.drive(0, 0, 0, 1);

        }

        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime){
          System.out.println("GOING FORWARD");
          driveSubsystem.drive(0.35, 0, 0, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime){
          driveSubsystem.drive(0, 0, 0, 1);
        }

        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime + spinTime){
          driveSubsystem.drive(0, 0, 0.5, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime + spinTime + restTime){
          driveSubsystem.drive(0, 0, 0, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime + spinTime + restTime + forwardTwoTime){
          driveSubsystem.drive(0.35, 0, 0, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime + spinTime + restTime + forwardTwoTime + restTime){
          driveSubsystem.drive(0, 0, 0, 1);
        }
        else if (Robot.autoTimer.get() < initialTime + spinTime + restTime + backwardTime + restTime + forwardTime + restTime + spinTime + restTime + forwardTime + restTime + shootTime){
          System.out.println("SHOOTING");
          shootSubSystem.shoot(-1, 0);
        }
        */

      }

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings

  
    driveSubsystem.setDefaultCommand(new DriveCommand(driveSubsystem, () -> controller.getRawAxis(0), () -> controller.getRawAxis(3) , () -> controller.getRawAxis(1),() -> 1.0));
    shootSubSystem.setDefaultCommand(new ShootCommand(shootSubSystem, () ->  controller.getRawAxis(5), () -> controller.getRawAxis(4)));
    intakerSubSystem.setDefaultCommand(new IntakeCommand(intakerSubSystem, () -> controller.getRawAxis(6)));
    configureBindings();

  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
