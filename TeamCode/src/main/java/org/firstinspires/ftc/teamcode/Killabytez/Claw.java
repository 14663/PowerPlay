package org.firstinspires.ftc.teamcode.Killabytez;

import static org.firstinspires.ftc.teamcode.util.Constants.CLAW_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.CLAW_OPEN;
import static org.firstinspires.ftc.teamcode.util.Constants.WRIST_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.WRIST_OPEN;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.util.Constants;

public class Claw {
    private Servo claw;
    private Servo wrist;
    private HardwareMap hardwareMap;

    public Claw(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
    }

    public void init() {
        claw = hardwareMap.get(Servo.class,"claw");
        wrist = hardwareMap.get(Servo.class, "wrist");
        claw.setPosition(CLAW_OPEN);
    }

    public void closeClaw() {
        claw.setPosition(CLAW_CLOSED);
    }
    public void openClaw() {
        claw.setPosition(CLAW_OPEN);
    }
    public void setClawPos(double pos) {
        claw.setPosition(pos);
    }

    public void closeWrist() {
        wrist.setPosition(WRIST_OPEN);
    }
    public void openWrist() {
        wrist.setPosition(WRIST_CLOSED);
    }
    public void setWristPos(double pos) {
        wrist.setPosition(pos);
    }

    public Servo getClaw() {
        return claw;
    }

    public Servo getWrist() {
        return wrist;
    }
}
