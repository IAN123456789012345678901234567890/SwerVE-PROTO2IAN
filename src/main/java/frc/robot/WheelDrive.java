package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class WheelDrive {
    private TalonFX angleMotor;
    private TalonFX speedMotor;
    private Encoder encoder1;
    private final double MAX_VOLTS = 9;
    
    
    public  WheelDrive (int angleMotor, int speedMotor, int encoder) {
        this.angleMotor = new TalonFX (angleMotor);
        this.speedMotor = new TalonFX (speedMotor);
      //      pidController = new Encoder (1, 0, 0, new AnalogInput (encoder), this.angleMotor);

          //  encoder1 = new Encoder()

          //      pidController.setOutputRange (-1, 1);
          //      pidController.setContinuous ();
          //      pidController.enable ();
    }
    public void drive (double speed, double angle) {
        speedMotor.set(ControlMode.PercentOutput, speed);

        double setpoint = angle * (MAX_VOLTS * 0.5) + (MAX_VOLTS * 0.5); // Optimization offset can be calculated here.
        if (setpoint < 0) {
            setpoint = MAX_VOLTS + setpoint;
        }
        if (setpoint > MAX_VOLTS) {
            setpoint = setpoint - MAX_VOLTS;
        }
    
     //   pidController.setSetpoint (setpoint);
    }
}
