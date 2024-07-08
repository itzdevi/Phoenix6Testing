package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class TimedCommandBase extends Command {
    private final Timer timer;
    private final double runTime;

    public TimedCommandBase(double runTime) {
        this.runTime = runTime;
        timer = new Timer();
    }

    @Override
    public void initialize() {
        timer.restart();
    }

    @Override
    public boolean isFinished() {
        return timer.get() >= runTime;
    }
}