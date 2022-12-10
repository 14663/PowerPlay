package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.CLAW_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.CLAW_OPEN;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class ClawTeleOpProcessor extends BaseProcessor {
    Servo claw;
    Servo wrist;
    public ClawTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init() {
       claw=opMode.hardwareMap.get(Servo.class, "claw");
       wrist=opMode.hardwareMap.get(Servo.class, "wrist");
    }

    @Override
    public void process() {
        claw.setPosition(0.8);
        sleep(1500);
        claw.setPosition(0.3);
    }
}