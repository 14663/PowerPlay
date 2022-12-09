package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ElevatorTeleOpProcessor extends BaseProcessor {
    public ElevatorTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        if (getGamepad(1).a)
            getKillabytezRobot().getElevator().lifting(2400, 0.75);

        if (getGamepad(1).b)
            getKillabytezRobot().getElevator().lifting(1100, 0.75);

        if (getGamepad(1).x)
            getKillabytezRobot().getElevator().lifting(700, 0.75);

        if (getGamepad(1).y)
            getKillabytezRobot().getElevator().reset(0.75);
    }
}
