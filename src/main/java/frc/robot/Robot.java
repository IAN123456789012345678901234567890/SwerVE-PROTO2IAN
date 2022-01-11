// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();

  private final XboxController m_controller = new XboxController(0);
  private final TalonFX OneMotor = new TalonFX(9);
//   private WheelDrive backRight = new WheelDrive (7, 8);
//   private WheelDrive backLeft = new WheelDrive (5, 6);
//   private WheelDrive frontRight = new WheelDrive (1, 2);
// private WheelDrive frontLeft = new WheelDrive (3, 4);
//private Joystick joystick = new Joystick (0);

//private SwerveDrive swerveDrive = new SwerveDrive (backRight, backLeft, frontRight, frontLeft);
 
  
  
  ShuffleboardTab ShootMotorTab;
  NetworkTableEntry ntShooterOutputPercent;
  
 



  
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);


    ntShooterOutputPercent = ShootMotorTab.add("set Shooter Speed", 0.5).withPosition(6, 1).withSize(2, 1).getEntry();
        ntShooterOutputPercent.setNumber(0.5);


  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  
  @Override
  public void teleopInit() {}

  
  @Override
  public void teleopPeriodic() {

    double shooterOutput = 0;
    

    if(m_controller.getAButton()){
      shooterOutput = ntShooterOutputPercent.getNumber(0).doubleValue();
    }

   // swerveDrive.drive (m_controller.getRawAxis (1), m_controller.getRawAxis (0), m_controller.getRawAxis (4));

    OneMotor.set(ControlMode.PercentOutput, shooterOutput);

  }
    

    

    
  



  @Override
  public void disabledInit() {}

 
  @Override
  public void disabledPeriodic() {}

 
  @Override
  public void testInit() {}

 
  @Override
  public void testPeriodic() {}
}
