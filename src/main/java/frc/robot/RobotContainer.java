package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ClawSubsystem;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.AutonomousDriveCommand;
import frc.robot.commands.OpenClawCommand;
import frc.robot.commands.CloseClawCommand;

public class RobotContainer {
  private final Joystick m_joystick = new Joystick(0);
  private final XboxController m_controller = new XboxController(1);

  private final DrivetrainSubsystem m_drivetrainSubsystem = new DrivetrainSubsystem();
  private final ClawSubsystem m_clawSubsystem = new ClawSubsystem();

  public RobotContainer() {
    m_drivetrainSubsystem.setDefaultCommand(new DriveCommand(m_drivetrainSubsystem, m_joystick));

    new JoystickButton(m_controller, XboxController.Button.kA.value)
        .onTrue(new OpenClawCommand(m_clawSubsystem));
    new JoystickButton(m_controller, XboxController.Button.kB.value)
        .onTrue(new CloseClawCommand(m_clawSubsystem));
  }

  public AutonomousDriveCommand getAutonomousCommand() {
    return new AutonomousDriveCommand(m_drivetrainSubsystem);
  }
}
