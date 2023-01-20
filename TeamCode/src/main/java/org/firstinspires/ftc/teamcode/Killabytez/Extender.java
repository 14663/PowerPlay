package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.List;

public class Extender {
    DcMotorEx leftExtender;
    DcMotorEx rightExtender;
    HardwareMap hardwareMap;
    private int originPos = 0;
    private int noPow = 0;

    public Extender(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
    }

    public void init() {

        leftExtender = hardwareMap.get(DcMotorEx.class, "leftextender");
        rightExtender = hardwareMap.get(DcMotorEx.class, "rightextender");

        leftExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightExtender.setDirection(DcMotor.Direction.REVERSE);

        leftExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void extendingLeft(int encoderTicks, double power) {
        int newLeftExtenderTarget = encoderTicks;

        leftExtender.setTargetPosition(newLeftExtenderTarget);

        leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftExtender.setPower(power);

        while(leftExtender.isBusy()) {

        }

        leftExtender.setPower(0);

        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void  extendingRight(int encoderTicks, double power) {
        int newRightExtenderTarget = encoderTicks;

        rightExtender.setTargetPosition(newRightExtenderTarget);

        rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightExtender.setPower(power);

        while(rightExtender.isBusy()) {

        }

        rightExtender.setPower(0);

        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void extending(int encoderTicks, double power) {
        int newLeftLiftTarget = encoderTicks;

        leftExtender.setTargetPosition(newLeftLiftTarget);
        rightExtender.setTargetPosition(newLeftLiftTarget);

        leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftExtender.setPower(power);
        rightExtender.setPower(power);

        while(leftExtender.isBusy() && rightExtender.isBusy()) {

        }

        leftExtender.setPower(noPow);
        rightExtender.setPower(noPow);

        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void reset(double power) {
        leftExtender.setTargetPosition(0);
        rightExtender.setTargetPosition(0);

        leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftExtender.setPower(power);
        rightExtender.setPower(power);

        while(leftExtender.isBusy() && rightExtender.isBusy()) {

        }

        leftExtender.setPower(noPow);
        rightExtender.setPower(noPow);

        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void resetLeft(double power) {
        leftExtender.setTargetPosition(originPos);

        leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftExtender.setPower(power);

        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void resetRight(double power) {
        rightExtender.setTargetPosition(originPos);

        rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        rightExtender.setPower(power);

        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void extendingTeleop(float leftTrigger) {

        leftExtender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftExtender.setPower(leftTrigger);
        rightExtender.setPower(leftTrigger);
    }

    public void retractingTeleop(float rightTrigger) {
        leftExtender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        leftExtender.setPower(-rightTrigger);
        rightExtender.setPower(-rightTrigger);

    }

    public DcMotor[] getExtenders() {
        return new DcMotorEx[] {leftExtender, rightExtender};
    }

    public boolean isBusy() {
        return leftExtender.isBusy() || rightExtender.isBusy();
    }
}
