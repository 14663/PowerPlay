package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Claw {
    private Servo Claw;
    private Servo Wrist;


    private int close = 1;
    private int open = 0;

    public Claw(HardwareMap hardwareMap) {
        Claw = hardwareMap.get(Servo.class,"claw");
        Wrist = hardwareMap.get(Servo.class, "wrist");

    }

    public void closeClaw() {
        Claw.setPosition(close);
    }
    public void openClaw() {
        Claw.setPosition(open);
    }
    public void setClawPos(double pos) { Claw.setPosition(pos);}

    public void closeWrist() { Wrist.setPosition(open);}
    public void openWrist() {Wrist.setPosition(close);}
    public void setWristPos(double pos) { Wrist.setPosition(pos);}






}
