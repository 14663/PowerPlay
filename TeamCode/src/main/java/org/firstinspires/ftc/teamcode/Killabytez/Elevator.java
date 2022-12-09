package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevator {
    public DcMotor elevator;
    public int low = 0;
    public int mid = 1100;
    public int high = 2400;


    public Elevator(HardwareMap hardwareMap) {
        elevator = hardwareMap.get(DcMotor.class, "elevator");

        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevator.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void lifting(int encoderTicks, double power) {
        int newLeftLiftTarget = encoderTicks;

        elevator.setTargetPosition(newLeftLiftTarget);

        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        elevator.setPower(power);

        while(elevator.isBusy()) {

        }

        elevator.setPower(0);

        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void reset(double power) {
        elevator.setTargetPosition(0);

        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        elevator.setPower(power);

        while(elevator.isBusy()) {

        }

        elevator.setPower(0);

        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public DcMotor getElevator() {
        return elevator;
    }
}
