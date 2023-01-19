package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Killabytez.Elevator;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Config
@Autonomous
public class ExtenderTesting extends LinearOpMode {
    public static int lifting = 500;
    public static double pow = 0.4;
    DcMotorEx leftExtender, rightExtender;

    final CyclicBarrier gate=new CyclicBarrier(3);

    Thread leftExtending=new Thread (new Runnable() {
        public void run() {
            try {
                gate.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            leftExtender.setTargetPosition(lifting);
            leftExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            leftExtender.setPower(pow);
        }
    });
    Thread rightExtending=new Thread (new Runnable() {
        public void run() {
            try {
                gate.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rightExtender.setTargetPosition(lifting/2);
            rightExtender.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            rightExtender.setPower(pow);
        }
    });
    @Override
    public void runOpMode() throws InterruptedException {
        leftExtender= hardwareMap.get(DcMotorEx.class, "leftextender");;
        rightExtender=hardwareMap.get(DcMotorEx.class, "rightextender");
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
        leftExtending.start();
        rightExtending.start();

        try {
            gate.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        while(leftExtender.isBusy() || rightExtender.isBusy()) {
            telemetry.addData("hello", leftExtender.getCurrentPosition());
            telemetry.addData("hell", rightExtender.getCurrentPosition());
            telemetry.update();
        }

        sleep(500);
        leftExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftExtender.setPower(0);
        rightExtender.setPower(0);
        leftExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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

