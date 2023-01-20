package org.firstinspires.ftc.teamcode.Killabytez;

import static org.firstinspires.ftc.teamcode.util.Constants.CloseLeftClaw;
import static org.firstinspires.ftc.teamcode.util.Constants.CloseRightClaw;
import static org.firstinspires.ftc.teamcode.util.Constants.LEFT_BICEP_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.LEFT_BICEP_OPEN;
import static org.firstinspires.ftc.teamcode.util.Constants.OpenLeftClaw;
import static org.firstinspires.ftc.teamcode.util.Constants.OpenRightClaw;
import static org.firstinspires.ftc.teamcode.util.Constants.RIGHT_BICEP_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.RIGHT_BICEP_OPEN;
import static org.firstinspires.ftc.teamcode.util.Constants.WRIST_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.WRIST_OPEN;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.util.Constants;
import org.firstinspires.ftc.teamcode.util.Constants.*;

public class VirtualFourBar {

    private Servo leftClaw;
    private Servo rightClaw;

    private Servo wrist;

    private Servo leftBicep;
    private Servo rightBicep;

    private HardwareMap hardwareMap;

    public VirtualFourBar(HardwareMap hardwareMap) {
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
        leftClaw.setPosition(OpenLeftClaw);
        rightClaw.setPosition(OpenRightClaw);
    }

    public void closeClaw() {
        leftClaw.setPosition(CloseLeftClaw);
        rightClaw.setPosition(CloseRightClaw);
    }

    public void openBicep() {
        leftBicep.setPosition(LEFT_BICEP_OPEN);
        rightBicep.setPosition(RIGHT_BICEP_OPEN);
    }

    public void closeBicep() {
        leftBicep.setPosition(LEFT_BICEP_CLOSED);
        rightBicep.setPosition(RIGHT_BICEP_CLOSED);
    }

    public void openWrist() {
        wrist.setPosition(WRIST_OPEN);
    }

    public void closeWrist() {
        wrist.setPosition(WRIST_CLOSED);
    }

}
