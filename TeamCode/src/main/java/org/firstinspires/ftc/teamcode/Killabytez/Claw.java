package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo Claw;

    private int close = 1;
    private int open = 0;

    public Claw(HardwareMap hardwareMap) {
        Claw = hardwareMap.get(Servo.class,"rightJaw");

    }

    public void closeClaw() {
        Claw.setPosition(close);
    }

    public void openClaw() {
        Claw.setPosition(open);
    }



}
