package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ClawAutoProcesor extends BaseProcessor {
    ClawMode clawMode;

    ClawAutoProcesor(LinearOpMode opMode, ClawMode clawMode) {
        super(opMode);
        this.clawMode=clawMode;
    }

    enum ClawMode {
        OPEN_CLAW, CLOSED_CLAW, OPEN_WRIST, CLOSED_WRIST
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        switch(clawMode) {
            case OPEN_CLAW: getKillabytezRobot().getClaw().openClaw();
            case CLOSED_CLAW: getKillabytezRobot().getClaw().closeClaw();
            case OPEN_WRIST: getKillabytezRobot().getClaw().openWrist();
            case CLOSED_WRIST: getKillabytezRobot().getClaw().closeWrist();
        }
    }
}
