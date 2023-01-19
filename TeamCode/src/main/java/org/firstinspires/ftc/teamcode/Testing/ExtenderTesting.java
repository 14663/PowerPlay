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
    public static double pow = 0.4;
    DcMotor leftExtender= hardwareMap.get(DcMotor.class, "leftextender");;
    DcMotor rightExtender=hardwareMap.get(DcMotor.class, "rightextender");
    Thread leftExtending=new Thread (new Runnable() {
        public void run() {
            leftExtender.setTargetPosition(lifting);
            leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftExtender.setPower(pow);
        }
    });
    Thread rightExtending=new Thread (new Runnable() {
        public void run() {
            rightExtender.setTargetPosition(lifting);
            rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightExtender.setPower(pow);
        }
    });
    @Override
    public void runOpMode() throws InterruptedException {

        //2400 ticks to top
        //1100 ticks to mid

        leftExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        /*leftExtender.setTargetPosition(lifting + leftExtender.getCurrentPosition());
        rightExtender.setTargetPosition(lifting + rightExtender.getCurrentPosition());
        leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftExtender.setPower(pow);
        rightExtender.setPower(pow);
*/
        //sync leftExtending and rightExtending threads
        leftExtending.join();
        rightExtending.join();
        leftExtending.start();
        rightExtending.start();
        sleep(500);
        leftExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        while(leftExtender.isBusy() || rightExtender.isBusy()) {



        }

        leftExtender.setPower(0);
        rightExtender.setPower(0);
        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        telemetry.addData("hello", leftExtender.getCurrentPosition());
        telemetry.addData("hell", rightExtender.getCurrentPosition());
        telemetry.update();

        /*sleep(1000);
        leftExtender.setTargetPosition(0);
        rightExtender.setTargetPosition(0);
        leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftExtender.setPower(pow);
        rightExtender.setPower(pow);

        while(leftExtender.isBusy()) {

        }

        leftExtender.setPower(0);
        rightExtender.setPower(0);
        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);*/
    }


}

