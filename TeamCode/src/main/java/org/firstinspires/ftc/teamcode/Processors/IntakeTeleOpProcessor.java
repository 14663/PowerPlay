package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_IN_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_IN_TICKS;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_OUT_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.EXTENDER_OUT_TICKS;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.Extender;
import org.firstinspires.ftc.teamcode.Killabytez.VirtualFourBar;

public class IntakeTeleOpProcessor extends BaseProcessor {

    public IntakeTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    private VirtualFourBar v4b;
    private Extender extender;

    @Override
    public void init() {
        v4b=getKillabytezRobot().getV4b();
        extender=getKillabytezRobot().getExtender();
        v4b.closeWrist();
        v4b.openBicep();
        v4b.openClaw();
    }

    @Override
    public void process() {
        if(getGamepad(2).left_bumper) v4b.openClaw();
        if (getGamepad(2).right_bumper) v4b.closeClaw();
        if(getGamepad(2).dpad_left) v4b.openBicep();
        if(getGamepad(2).dpad_right) v4b.closeBicep();
        if(getGamepad(2).dpad_up) v4b.openWrist();
        if(getGamepad(2).dpad_down) v4b.closeWrist();
        if(getGamepad(2).a) {
            extender.extending(1900, 0.7);
            sleep(500);
            v4b.closeClaw();
            extender.reset(0.7);
            sleep(500);
            v4b.closeBicep();
            sleep(500);
            v4b.openWrist();
            sleep(600);
            v4b.openClaw();
            sleep(500);
            v4b.closeClaw();
            v4b.closeWrist();
            v4b.openBicep();
            v4b.openClaw();
        }
        if(getGamepad(2).right_trigger>0) {
            extender.reset(0.7);
            v4b.closeWrist();
            v4b.openBicep();
            v4b.openClaw();
        }
    }
}