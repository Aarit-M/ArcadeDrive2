package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClawSubsystem;

public class OpenClawCommand extends CommandBase {
  private final ClawSubsystem m_clawSubsystem;

  public OpenClawCommand(ClawSubsystem clawSubsystem) {
    m_clawSubsystem = clawSubsystem;
    addRequirements(clawSubsystem);
  }

  @Override
  public void initialize() {
    m_clawSubsystem.openClaw();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
