package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;


@Config
@Autonomous
public class ElevatorTesting extends LinearOpMode {
    public static int lifting = -500;
    public static double pow = 0.9;
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor leftelevator;
        DcMotor rightelevator;
        leftelevator = hardwareMap.get(DcMotor.class, "leftElevator");
        rightelevator = hardwareMap.get(DcMotor.class, "rightElevator");
        //2400 ticks to top
        //1100 ticks to mid
        leftelevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightelevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        leftelevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightelevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        leftelevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightelevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();
        leftelevator.setTargetPosition(lifting);
        rightelevator.setTargetPosition(lifting);
        leftelevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightelevator.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftelevator.setPower(pow);
        rightelevator.setPower(pow);

        while(leftelevator.isBusy()) {

        }

        leftelevator.setPower(0);
        rightelevator.setPower(0);
        leftelevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightelevator.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("hello", leftelevator.getCurrentPosition());
        telemetry.update();


    }


    }

