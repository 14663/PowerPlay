package org.firstinspires.ftc.teamcode.Killabytez;

import static org.firstinspires.ftc.teamcode.util.Constants.closedPosBucket;
import static org.firstinspires.ftc.teamcode.util.Constants.openPosBucket;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Bucket {
     Servo arm;

    private HardwareMap hardwareMap;

    public Bucket(HardwareMap hardwareMap) {
        this.hardwareMap = hardwareMap;
    }
    public void init() {
        arm = hardwareMap.get(Servo.class, "bucket");
    }

    public void openServo() {
        arm.setPosition(openPosBucket);
    }
    public void closeServo() {
        arm.setPosition(closedPosBucket);
    }

    public void setPos(double pos) {
        arm.setPosition(pos);
    }
}

