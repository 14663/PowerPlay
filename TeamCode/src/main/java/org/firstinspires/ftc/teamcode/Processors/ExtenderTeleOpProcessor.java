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
        if(getGamepad(2).left_bumper) getKillabytezRobot().getExtender().extending(0, -1.0);
        if(getGamepad(2).right_bumper) getKillabytezRobot().getExtender().extending(-1100, 0.8);
    }
}