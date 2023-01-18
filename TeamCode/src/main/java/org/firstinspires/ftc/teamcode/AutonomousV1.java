package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

/*
 * This is an example of a more complex path to really test the tuning.
 */
@Autonomous(group = "auto")
public class AutonomousV1 extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        waitForStart();

        if (isStopRequested()) return;



        //trajectory to go forward
        Trajectory traj1 = drive.trajectoryBuilder(new Pose2d())
                        .strafeLeft(56)
                                .build();
        //trajectory to reset
        Trajectory traj2 = drive.trajectoryBuilder(traj1.end())
                        .strafeRight(56)
                                .build();


        drive.followTrajectory(traj1);
        drive.turn(Math.toRadians(35));
        sleep(2000);
        drive.turn(-Math.toRadians(35));

        drive.followTrajectory(traj2);

    }
}