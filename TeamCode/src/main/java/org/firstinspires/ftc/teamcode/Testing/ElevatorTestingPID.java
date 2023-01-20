package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.util.Encoder;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Config
@Autonomous
public class ElevatorTestingPID extends LinearOpMode {

    public DcMotorEx leftElevator;
    public double Kp_left;
    public double Ki_left;
    public double Kd_left;
    public double reference_left=500;
    public double maxIntegralSum_left;
    public double errorTolerance_left;

    public DcMotorEx rightElevator;
    public double Kp_right;
    public double Ki_right;
    public double Kd_right;
    public double reference_right=500;
    public double maxIntegralSum_right;
    public double errorTolerance_right;

    EncoderPID leftElevating;
    EncoderPID rightElevating;

    @Override
    public void runOpMode() throws InterruptedException {
        leftElevator=hardwareMap.get(DcMotorEx.class, "leftextender");
        rightElevator=hardwareMap.get(DcMotorEx.class, "rightextender");
        leftElevating=new EncoderPID(leftElevator, Kp_left, Ki_left, Kd_left, reference_left, maxIntegralSum_left, errorTolerance_left);
        rightElevating=new EncoderPID(rightElevator, Kp_right, Ki_right, Kd_right, reference_right, maxIntegralSum_right, errorTolerance_right);

        leftElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightElevator.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightElevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftElevator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightElevator.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while(leftElevating.isSetPointIsNotReached() || rightElevating.isSetPointIsNotReached()) {
            leftElevating.run();
            rightElevating.run();
            sleep(500);
        }
    }
}
