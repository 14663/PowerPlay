package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Extender {
    DcMotor extender;
    HardwareMap hardwareMap;
    private int originPos = 0;
    private int noPow = 0;

    public Extender(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
    }

    public void init() {
        extender = hardwareMap.get(DcMotor.class, "extender");
        extender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        extender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void extending(int encoderTicks, double power) {
        int newLeftLiftTarget = extender.getCurrentPosition() + encoderTicks;

        extender.setTargetPosition(newLeftLiftTarget);
        extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extender.setPower(power);

        while(extender.isBusy()) {

        }

        extender.setPower(noPow);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void reset(double power) {

        extender.setTargetPosition(originPos);
        extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        extender.setPower(power);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void extendingTeleop(float leftTrigger) {
        extender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender.setPower(leftTrigger);
    }

    public void retractingTeleop(float rightTrigger) {
        extender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        extender.setPower(-rightTrigger);

    }

    public DcMotor getExtender() {
        return extender;
    }
}
