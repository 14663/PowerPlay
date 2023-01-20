package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class V4B {

    private Servo leftClaw;

    private double OpenLeftClaw = 0.3;
    private double OpenRightClaw = 0.7;

    private Servo rightClaw;
    private Servo wrist;

    private Servo leftBicep;
    private Servo rightBicep;

    private HardwareMap hardwareMap;

    public V4B(HardwareMap hardwareMap) {
       this.hardwareMap = hardwareMap;
    }

    public void init() {

        leftClaw = hardwareMap.get(Servo.class, "leftClaw");
        rightClaw = hardwareMap.get(Servo.class, "rightClaw");
        wrist = hardwareMap.get(Servo.class, "wrist");
        leftBicep = hardwareMap.get(Servo.class, "leftBicep");
        rightBicep = hardwareMap.get(Servo.class, "rightBicep");

    }

    public void openClaw() {

        leftClaw.setPosition(0);
        rightClaw.setPosition(1);
    }



}
