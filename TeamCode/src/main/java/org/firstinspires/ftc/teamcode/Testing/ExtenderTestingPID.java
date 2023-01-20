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
public class ExtenderTestingPID extends LinearOpMode {

    public DcMotorEx leftExtender;
    public double Kp_left;
    public double Ki_left;
    public double Kd_left;
    public double reference_left=500;
    public double maxIntegralSum_left;
    public double errorTolerance_left;

    public DcMotorEx rightExtender;
    public double Kp_right;
    public double Ki_right;
    public double Kd_right;
    public double reference_right=500;
    public double maxIntegralSum_right;
    public double errorTolerance_right;

    EncoderPID leftExtending;
    EncoderPID rightExtending;

    @Override
    public void runOpMode() throws InterruptedException {
        leftExtender=hardwareMap.get(DcMotorEx.class, "leftextender");
        rightExtender=hardwareMap.get(DcMotorEx.class, "rightextender");
        leftExtending=new EncoderPID(leftExtender, Kp_left, Ki_left, Kd_left, reference_left, maxIntegralSum_left, errorTolerance_left);
        rightExtending=new EncoderPID(rightExtender, Kp_right, Ki_right, Kd_right, reference_right, maxIntegralSum_right, errorTolerance_right);

        leftExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightExtender.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftExtender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightExtender.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        while(leftExtending.isSetPointIsNotReached() || rightExtending.isSetPointIsNotReached()) {
            leftExtending.run();
            rightExtending.run();
            sleep(500);
        }
    }
}
