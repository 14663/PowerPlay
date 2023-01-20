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
        robot.getExtender().extending(500, 0.1);
        sleep(500);
        robot.getExtender().reset(0.1);

        }
}




