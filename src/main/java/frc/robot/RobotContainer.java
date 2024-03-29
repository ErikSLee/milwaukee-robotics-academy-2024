// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.Positions.Pickup;
import frc.robot.Constants.Positions.Place;
import frc.robot.Constants.Positions.PrepareToPickup;
import frc.robot.commands.TankDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Shooter m_elevator = new Shooter();

  private final XboxController m_driver = new XboxController(0);

  private final Command m_autonomousCommand;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Put Some buttons on the SmartDashboard
    

    // Assign default commands
    m_drivetrain.setDefaultCommand(
        new TankDrive(() -> -m_driver.getLeftY(), () -> -m_driver.getRightY(), m_drivetrain));
    
    m_autonomousCommand = new WaitCommand(1);

    // Show what command your subsystem is running on the SmartDashboard
    SmartDashboard.putData(m_drivetrain);
    SmartDashboard.putData(m_elevator);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Create some buttons
    final JoystickButton dpadUp = new JoystickButton(m_driver, 5);
    final JoystickButton dpadRight = new JoystickButton(m_driver, 6);
    final JoystickButton dpadDown = new JoystickButton(m_driver, 7);
    final JoystickButton dpadLeft = new JoystickButton(m_driver, 8);
    final JoystickButton l2 = new JoystickButton(m_driver, 9);
    final JoystickButton r2 = new JoystickButton(m_driver, 10);
    final JoystickButton l1 = new JoystickButton(m_driver, 11);
    final JoystickButton r1 = new JoystickButton(m_driver, 12);

    // Connect the buttons to commands
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return m_autonomousCommand;
  }
}
