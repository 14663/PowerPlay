package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Killabytez.Elevator;

@Config
@Autonomous
public class ExtenderTesting extends LinearOpMode {
    public static int lifting = 500;
    public static double pow = 0.9;
    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor extender;
        extender = hardwareMap.get(DcMotor.class, "extender");
        //2400 ticks to top
        //1100 ticks to mid
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        extender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        waitForStart();
        extender.setTargetPosition(lifting + extender.getCurrentPosition());
        extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extender.setPower(pow);

        while(extender.isBusy()) {

        }

        extender.setPower(0);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("hello", extender.getCurrentPosition());
        telemetry.update();

        sleep(1000);
        extender.setTargetPosition(0);
        extender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extender.setPower(pow);

        while(extender.isBusy()) {

        }

        extender.setPower(0);
        extender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }


}

