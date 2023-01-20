package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;

@Autonomous
public class bucketTest extends LinearOpMode {

    KillabytezRobot robot = new KillabytezRobot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        robot.getBucket().openServo();
        sleep(5000);
        robot.getBucket().closeServo();
        sleep(5000);
        robot.getBucket().openServo();


    }
}

