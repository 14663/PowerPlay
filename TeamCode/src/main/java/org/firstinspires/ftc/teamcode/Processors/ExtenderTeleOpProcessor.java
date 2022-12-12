package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_IN_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_IN_TICKS;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_OUT_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_OUT_TICKS;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ExtenderTeleOpProcessor extends BaseProcessor {
    public ExtenderTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        if(getGamepad(2).right_stick_button) getKillabytezRobot().getExtender().extending(EXTENDER_OUT_TICKS, EXTENDER_OUT_POWER);
        if(getGamepad(2).left_stick_button) getKillabytezRobot().getExtender().extending(EXTENDER_IN_TICKS, EXTENDER_IN_POWER);

    }
}