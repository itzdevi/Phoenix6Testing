package frc.robot.commands;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

public class RunTalonVelocity extends TimedCommandBase {
    private final TalonFX motor;
    private final double velocityRps;

    public RunTalonVelocity(int motorId, double velocityRps) {
        super(3);
        motor = new TalonFX(motorId);
        Slot0Configs slot0 = new Slot0Configs();
        slot0.kS = 1;
        slot0.kP = 1;
        motor.getConfigurator().apply(slot0);
        this.velocityRps = velocityRps;
    }

    @Override
    public void execute() {
        VelocityVoltage request = new VelocityVoltage(0).withSlot(0);
        motor.setControl(request.withVelocity(velocityRps));
    }

    @Override
    public void end(boolean interrupted) {
        motor.set(0);
    }
}