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
        getKillabytezRobot().getExtender().extendingTeleop(getGamepad(2).left_trigger);
        getKillabytezRobot().getExtender().retractingTeleop(getGamepad(2).right_trigger);
    }
}