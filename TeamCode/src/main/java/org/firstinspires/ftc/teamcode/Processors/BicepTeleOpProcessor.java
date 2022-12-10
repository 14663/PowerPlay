package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class BicepTeleOpProcessor extends BaseProcessor {

    public BicepTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        if(getGamepad(2).dpad_up) getKillabytezRobot().getBicep().openBicep();
        if(getGamepad(2).dpad_down) getKillabytezRobot().getBicep().closeBicep();
        if(getGamepad(2).dpad_right) getKillabytezRobot().getBicep().openClasp();
        if(getGamepad(2).dpad_left) getKillabytezRobot().getBicep().closeClasp();
    }
}
