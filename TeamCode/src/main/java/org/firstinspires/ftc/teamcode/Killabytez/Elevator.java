package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevator {
    public DcMotor leftElevator;
    public DcMotor rightElevator;
    private HardwareMap hardwareMap;

    public Elevator(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
    }

    public void init() {
        leftElevator = hardwareMap.get(DcMotor.class, "leftElevator");
        rightElevator = hardwareMap.get(DcMotor.class, "rightElevator");

        leftElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightElevator.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void lifting(int encoderTicks, double power) {
        int newLeftLiftTarget = encoderTicks;

        leftElevator.setTargetPosition(newLeftLiftTarget);
        rightElevator.setTargetPosition(newLeftLiftTarget);

        leftElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftElevator.setPower(power);
        rightElevator.setPower(power);

        while(leftElevator.isBusy() && rightElevator.isBusy()) {

        }

        leftElevator.setPower(0);
        rightElevator.setPower(0);

        leftElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


    }




    public void reset(double power) {
        leftElevator.setTargetPosition(0);
        rightElevator.setTargetPosition(0);

        leftElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightElevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftElevator.setPower(power);

        while(leftElevator.isBusy() && rightElevator.isBusy()) {

        }

        leftElevator.setPower(0);
        rightElevator.setPower(0);

        leftElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightElevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public double getLeftElevator() {
        return leftElevator.getCurrentPosition();
    }

    public double getRightElevator() {
        return rightElevator.getCurrentPosition();
    }
}
