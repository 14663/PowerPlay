package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Bucket {
     Servo arm;

    private int openPos = 0;
    private int closedPos = 1;
    private HardwareMap hardwareMap;

    public Bucket(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }
    public void init() {
        arm = hardwareMap.get(Servo.class, "bucket");
    }

    public void openServo() {
        arm.setPosition(openPos);
    }
    public void closeServo() {
        arm.setPosition(closedPos);
    }

    public void setPos(double pos) {
        arm.setPosition(pos);
    }
}

