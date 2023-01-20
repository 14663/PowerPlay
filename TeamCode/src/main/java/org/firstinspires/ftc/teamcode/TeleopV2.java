package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/**
 * This is a simple teleop routine for testing localization. Drive the robot around like a normal
 * teleop routine and make sure the robot's estimated pose matches the robot's actual pose (slight
 * errors are not out of the ordinary, especially with sudden drive motions). The goal of this
 * exercise is to ascertain whether the localizer has been configured properly (note: the pure
 * encoder localizer heading may be significantly off if the track width has not been tuned).
 */
@TeleOp(group = "drive")
public class TeleopV2 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        KillabytezRobot robot = new KillabytezRobot();

        drive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();

        robot.init(hardwareMap);
        while (!isStopRequested()) {
            drive.setWeightedDrivePower(
                    new Pose2d(
                            -gamepad1.left_stick_y *0.9,
                            -gamepad1.left_stick_x *0.9,
                            -gamepad1.right_stick_x *0.9
                    )
            );
            if (gamepad1.a) drive.turn(Math.toRadians(90));

            if(gamepad2.left_bumper) robot.getV4b().openClaw();
            if(gamepad2.right_bumper) robot.getV4b().closeClaw();
            if(gamepad2.dpad_left) robot.getV4b().openBicep();
            if(gamepad2.dpad_right) robot.getV4b().closeBicep();
            if(gamepad2.dpad_up) robot.getV4b().openWrist();
            if(gamepad2.dpad_down) robot.getV4b().closeWrist();


            drive.update();

            Pose2d poseEstimate = drive.getPoseEstimate();
            telemetry.addData("x", poseEstimate.getX());
            telemetry.addData("y", poseEstimate.getY());
            telemetry.addData("heading", poseEstimate.getHeading());
            telemetry.update();
        }
    }
}