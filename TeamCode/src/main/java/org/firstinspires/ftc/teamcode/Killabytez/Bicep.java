package org.firstinspires.ftc.teamcode.Killabytez;

import static org.firstinspires.ftc.teamcode.util.Constants.BICEP_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.BICEP_OPEN;
import static org.firstinspires.ftc.teamcode.util.Constants.CLASP_CLOSED;
import static org.firstinspires.ftc.teamcode.util.Constants.CLASP_OPEN;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Processors.BaseProcessor;

public class Bicep {
    private Servo clasp;
    private Servo bicep;
    private HardwareMap hardwareMap;

    public enum BicepMode {
        OPEN_BICEP, CLOSED_BICEP, OPEN_CLASP, CLOSED_CLASP
    }

    public Bicep(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
    }

    public void init() {
        bicep = hardwareMap.get(Servo.class,"bicep");
        clasp = hardwareMap.get(Servo.class, "clasp");
    }

    public void openBicep() {
        bicep.setPosition(BICEP_OPEN);
    }
    public void closeBicep() {
        bicep.setPosition(BICEP_CLOSED);
    }
    public void openClasp() {
        clasp.setPosition(CLASP_OPEN);
    }
    public void closeClasp() {
        clasp.setPosition(CLASP_CLOSED);
    }
}
