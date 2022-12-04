package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Killabytez.Elevator;

@Config
@Autonomous
public class ElevatorTesting extends LinearOpMode {
    public static int lifting = -500;
    public static double pow = 0.9;
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor elevator;
        elevator = hardwareMap.get(DcMotor.class, "elevator");
        //2400 ticks to top
        //1100 ticks to mid
        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        elevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();
        elevator.setTargetPosition(lifting + elevator.getCurrentPosition());
        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevator.setPower(pow);

        while(elevator.isBusy()) {

        }

        elevator.setPower(0);
        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("hello", elevator.getCurrentPosition());
        telemetry.update();

        sleep(1000);
        elevator.setTargetPosition(0);
        elevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        elevator.setPower(pow);

        while(elevator.isBusy()) {

        }

        elevator.setPower(0);
        elevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


    }

