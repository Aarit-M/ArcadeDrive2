package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClawSubsystem extends SubsystemBase {
  private final PneumaticHub m_pneumaticHub = new PneumaticHub(1);
  private final Solenoid m_clawSolenoid = m_pneumaticHub.makeSolenoid(0);

  public ClawSubsystem() {
    m_pneumaticHub.enableCompressorDigital();
  }

  public void openClaw() {
    m_clawSolenoid.set(true);
  }

  public void closeClaw() {
    m_clawSolenoid.set(false); 
  }
}
