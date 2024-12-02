package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class DrivetrainSubsystem extends SubsystemBase {
  private final CANSparkMax m_leftFrontMotor = new CANSparkMax(1, MotorType.kBrushless);
  private final CANSparkMax m_leftRearMotor = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_rightFrontMotor = new CANSparkMax(3, MotorType.kBrushless);
  private final CANSparkMax m_rightRearMotor = new CANSparkMax(4, MotorType.kBrushless);
  private final DifferentialDrive m_drive = new DifferentialDrive(
      m_leftFrontMotor::set, 
      m_rightFrontMotor::set
  );

  public DrivetrainSubsystem() {
    m_rightFrontMotor.setInverted(true);
    m_rightRearMotor.setInverted(true);
  }

  public void arcadeDrive(double forward, double rotation) {
    m_drive.arcadeDrive(forward, rotation);
  }

  public void stop() {
    m_drive.stopMotor();
  }
}
