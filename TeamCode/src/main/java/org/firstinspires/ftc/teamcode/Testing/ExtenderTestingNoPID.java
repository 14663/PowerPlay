package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;

@Config
 @Autonomous
public class ExtenderTestingNoPID extends LinearOpMode {
    KillabytezRobot robot = new KillabytezRobot();

    public static int pos = 500;
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        //run the left extender
        robot.getExtender().extending(pos, 0.5);
        sleep(500);
        robot.getExtender().extending(0, 0.5);

        }
}




