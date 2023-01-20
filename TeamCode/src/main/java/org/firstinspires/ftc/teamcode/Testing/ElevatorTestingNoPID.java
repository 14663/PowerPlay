package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;

@Autonomous

public class ElevatorTestingNoPID extends LinearOpMode {
    KillabytezRobot robot = new KillabytezRobot();
    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        waitForStart();

        //run the left extender
        robot.getElevator().lifting(500, 0.1);
        robot.getElevator().reset(0.1);

        }
}

