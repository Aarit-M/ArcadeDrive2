package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

public class AutonomousDriveCommand extends CommandBase {
  private final DrivetrainSubsystem m_drivetrain;
  private long m_startTime;

  public AutonomousDriveCommand(DrivetrainSubsystem drivetrain) {
    m_drivetrain = drivetrain;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    m_startTime = System.currentTimeMillis();
  }

  @Override
  public void execute() {
    long elapsedTime = System.currentTimeMillis() - m_startTime;

    if (elapsedTime < 15000) {
      m_drivetrain.arcadeDrive(0.5, 0); 
    } else if (elapsedTime < 18000) {
      m_drivetrain.arcadeDrive(0, 0.5); 
    } else {
      m_drivetrain.stop();
    }
  }

  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() - m_startTime > 18000;
  }

  @Override
  public void end(boolean interrupted) {
    m_drivetrain.stop();
  }
}
