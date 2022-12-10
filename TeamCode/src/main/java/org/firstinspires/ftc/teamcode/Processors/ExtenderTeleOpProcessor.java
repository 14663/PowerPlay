package org.firstinspires.ftc.teamcode.Processors;

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
        if(getGamepad(2).right_stick_button) getKillabytezRobot().getExtender().extending(-1100, 0.8);
        if(getGamepad(2).left_stick_button) getKillabytezRobot().getExtender().extending(0, -1.0);

    }
}