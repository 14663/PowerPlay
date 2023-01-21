package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "auto")
public class AutonomousV1 extends LinearOpMode {
    KillabytezRobot robot = new KillabytezRobot();

    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);
        robot.init(hardwareMap);
        waitForStart();

        if (isStopRequested()) return;



        //trajectory to go forward
        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                        .strafeLeft(56)
                        .addTemporalMarker(2, () -> {
                           robot.getElevator().lifting(1600,0.5);
                        })
                                .build();
        //trajectory to reset
        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                        .strafeRight(12)
                        .addTemporalMarker(2, () -> {
                            robot.getElevator().lifting(1600,0.5);
                    })
                                .build();



        drive.followTrajectory(traj1);
        sleep(500);
        robot.getBucket().closeServo();
        sleep(1000);
        robot.getBucket().openServo();
        ;

        drive.followTrajectory(traj2);

    }
}