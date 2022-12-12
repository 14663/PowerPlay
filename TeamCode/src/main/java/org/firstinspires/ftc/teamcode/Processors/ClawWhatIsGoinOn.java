package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="CLAW ", group="sdas")
public class ClawWhatIsGoinOn extends LinearOpMode {
    Servo claw;
    Servo wrist;
    @Override
    public void runOpMode() throws InterruptedException {
        claw=hardwareMap.get(Servo.class, "claw");
        wrist=hardwareMap.get(Servo.class, "wrist");
        waitForStart();
        if(opModeIsActive()) {
            claw.setPosition(0.8);
            wrist.setPosition(0.8);
            sleep(1500);
            claw.setPosition(0.3);
            wrist.setPosition(0.3);
        }
    }
}
