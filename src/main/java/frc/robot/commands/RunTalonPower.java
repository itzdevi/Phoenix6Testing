package frc.robot.commands;

import com.ctre.phoenix6.hardware.TalonFX;

public class RunTalonPower extends TimedCommandBase {
    private final TalonFX motor;
    private final double power;

    public RunTalonPower(int motorId, double power) {
        super(3);
        motor = new TalonFX(motorId);
        this.power = power;
    }

    @Override
    public void execute() {
        motor.set(power);
    }

    @Override
    public void end(boolean interrupted) {
        motor.set(0);
    }
}
