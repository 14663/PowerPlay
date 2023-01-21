package org.firstinspires.ftc.teamcode.Testing;

import static org.firstinspires.ftc.teamcode.util.Constants.extenderOut;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Killabytez.Extender;
import org.firstinspires.ftc.teamcode.Killabytez.VirtualFourBar;

@Config
@TeleOp
public class V4B_TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        VirtualFourBar v4b=new VirtualFourBar(hardwareMap);
        v4b.init();
        Extender extender=new Extender(hardwareMap);
        extender.init();
        v4b.closeWrist();
        v4b.openBicep();
        v4b.openClaw();
        waitForStart();
        while(opModeIsActive()) {
            if(gamepad1.left_bumper) v4b.openClaw();
            if (gamepad1.right_bumper) v4b.closeClaw();
            if(gamepad1.dpad_left) v4b.openBicep();
            if(gamepad1.dpad_right) v4b.closeBicep();
            if(gamepad1.dpad_up) v4b.openWrist();
            if(gamepad1.dpad_down) v4b.closeWrist();
            if(gamepad1.a) {
                extender.extending(extenderOut, 0.7);
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
            sleep(50);
        }
    }
}
