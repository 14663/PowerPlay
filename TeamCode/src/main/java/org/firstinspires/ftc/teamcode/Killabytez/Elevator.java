package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Elevator {
    public DcMotor elevator;
    public int intake, low, mid, high;


    public Elevator(HardwareMap hardwareMap) {
        elevator = hardwareMap.get(DcMotor.class, "elevator");

        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void lifting(int encoderTicks, double power) {
        int newLeftLiftTarget = elevator.getCurrentPosition() + encoderTicks;

        elevator.setTargetPosition(newLeftLiftTarget);

        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        elevator.setPower(power);

        elevator.setPower(0);

        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void reset(double power) {
        elevator.setTargetPosition(0);

        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        elevator.setPower(power);

        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
