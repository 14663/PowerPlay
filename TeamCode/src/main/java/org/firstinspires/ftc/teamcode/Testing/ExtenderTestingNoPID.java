package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;

@Autonomous
public class ExtenderTestingNoPID extends LinearOpMode {
    KillabytezRobot robot = new KillabytezRobot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        //run the left extender
        robot.getExtender().extending(1000, 0.5);
        sleep(500);
        robot.getExtender().extending(0, 0.5);

        }
}




