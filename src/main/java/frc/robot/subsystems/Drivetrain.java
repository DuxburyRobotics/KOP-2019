/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
  private Talon cFrontRight;
  private Talon cRearRight;
  private Talon cFrontLeft;
  private Talon cRearLeft;

  private SpeedControllerGroup cRight;
  private SpeedControllerGroup cLeft;

  public DifferentialDrive rDrive;

  public Drivetrain() {
    cFrontRight = new Talon(RobotMap.frontRight);
    cRearRight = new Talon(RobotMap.rearRight);
    cFrontLeft = new Talon(RobotMap.frontLeft);
    cRearLeft = new Talon(RobotMap.rearLeft);

    cRight = new SpeedControllerGroup(cFrontRight, cRearRight);
    cLeft = new SpeedControllerGroup(cFrontLeft, cRearLeft);

    rDrive = new DifferentialDrive(cLeft, cRight);
  }

  public void teleopDrive(double throttle, double turn) {
    rDrive.arcadeDrive(throttle, turn);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveArcade());
  }
}
