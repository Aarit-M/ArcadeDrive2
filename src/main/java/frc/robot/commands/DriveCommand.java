package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj.Joystick;

public class DriveCommand extends CommandBase {
  private final DrivetrainSubsystem m_drivetrain;
  private final Joystick m_joystick;

  public DriveCommand(DrivetrainSubsystem drivetrain, Joystick joystick) {
    m_drivetrain = drivetrain;
    m_joystick = joystick;
    addRequirements(drivetrain);
  }

  @Override
  public void execute() {
    m_drivetrain.arcadeDrive(-m_joystick.getY(), -m_joystick.getX());
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }
}
