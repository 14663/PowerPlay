package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ClawTeleOpProcessor extends BaseProcessor {
    public ClawTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        if (getGamepad(2).left_bumper) getKillabytezRobot().getClaw().closeClaw();
        if (getGamepad(2).right_bumper) getKillabytezRobot().getClaw().openClaw();
        if(getGamepad(2).back) getKillabytezRobot().getClaw().closeWrist();
        if(getGamepad(2).left_stick_button) getKillabytezRobot().getClaw().openWrist();
    }
}