package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;

@Autonomous
@Config



public class ElevatorTestingNoPID extends LinearOpMode {
    public static double pow = 0.5;
    public static int pos = 1600;
    KillabytezRobot robot = new KillabytezRobot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        //run the left extender
        robot.getElevator().lifting(pos,pow);

        robot.getElevator().lifting(0,pow);


























        }
}

