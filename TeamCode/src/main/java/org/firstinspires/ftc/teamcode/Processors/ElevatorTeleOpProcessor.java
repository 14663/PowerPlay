package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.ELEVATOR_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.HIGH_ELEVATOR_HEIGHT;
import static org.firstinspires.ftc.teamcode.util.Constants.LOW_ELEVATOR_HEIGHT;
import static org.firstinspires.ftc.teamcode.util.Constants.MID_ELEVATOR_HEIGHT;

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
        if (getGamepad(2).a)
            getKillabytezRobot().getElevator().lifting(HIGH_ELEVATOR_HEIGHT, ELEVATOR_POWER);

        if (getGamepad(2).b)
            getKillabytezRobot().getElevator().lifting(MID_ELEVATOR_HEIGHT, ELEVATOR_POWER);

        if (getGamepad(2).x)
            getKillabytezRobot().getElevator().lifting(LOW_ELEVATOR_HEIGHT, ELEVATOR_POWER);

        if (getGamepad(2).y)
            getKillabytezRobot().getElevator().reset(ELEVATOR_POWER);
        if(getGamepad(2).a || getGamepad(2).b || getGamepad(2).x || getGamepad(2).y) getKillabytezRobot().getClaw().closeWrist();
    }
}
