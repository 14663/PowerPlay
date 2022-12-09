package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Extender {
    DcMotor extender;
    private int originPos = 0;
    private int noPow = 0;

    public Extender(HardwareMap hardwareMap) {
        extender = hardwareMap.get(DcMotor.class, "extender");
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        extender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void extending(int encoderTicks, double power) {
        int newLeftLiftTarget = extender.getCurrentPosition() + encoderTicks;

        extender.setTargetPosition(newLeftLiftTarget);
        extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extender.setPower(power);

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
        extender.setPower(leftTrigger * 0.75);

    }

    public void retractingTeleop(float rightTrigger) {
        extender.setPower(-rightTrigger * 0.75);

    }

    public DcMotor getExtender() {
        return extender;
    }
}
