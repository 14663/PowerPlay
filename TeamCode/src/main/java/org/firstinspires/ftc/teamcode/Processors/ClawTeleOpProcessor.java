package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_IN_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_IN_TICKS;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_OUT_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_OUT_TICKS;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ClawTeleOpProcessor extends BaseProcessor {
    boolean extended=false;

    public ClawTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init() {
        getKillabytezRobot().getClaw().init();
    }

    @Override
    public void process() {
        if(getGamepad(2).right_trigger>0 && !extended) {
            getKillabytezRobot().getClaw().closeWrist();
            getKillabytezRobot().getClaw().openClaw();
            getKillabytezRobot().getExtender().extending(EXTENDER_OUT_TICKS, EXTENDER_OUT_POWER);
            while(getKillabytezRobot().getExtender().isBusy()) {

            }
            getKillabytezRobot().getClaw().closeWrist();
            getKillabytezRobot().getClaw().closeClaw();
            extended=true;
        }
        if(getGamepad(2).left_trigger>0 && extended) {
            getKillabytezRobot().getExtender().extending(EXTENDER_IN_TICKS, EXTENDER_IN_POWER);
            while(getKillabytezRobot().getExtender().isBusy()) {

            }
            getKillabytezRobot().getClaw().openWrist();
            getKillabytezRobot().getBicep().closeClasp();
            sleep(1500);
            getKillabytezRobot().getClaw().openClaw();
            getKillabytezRobot().getBicep().openBicep();
            extended=false;
        }

    }
}