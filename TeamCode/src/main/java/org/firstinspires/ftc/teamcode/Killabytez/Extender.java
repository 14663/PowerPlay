package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Extender {
    DcMotor extender;

    public Extender(HardwareMap hardwareMap) {
        extender = hardwareMap.get(DcMotor.class, "extender");
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        extender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void lifting(int encoderTicks, double power) {
        int newLeftLiftTarget = extender.getCurrentPosition() + encoderTicks;

        extender.setTargetPosition(newLeftLiftTarget);
        extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extender.setPower(power);

        extender.setPower(0);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void reset(double power) {

        extender.setTargetPosition(0);
        extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        extender.setPower(power);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


}
