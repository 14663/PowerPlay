package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Killabytez.Elevator;
import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;

@Config
@Autonomous
public class ElevatorTesting extends LinearOpMode {
    KillabytezRobot robot = new KillabytezRobot();

    public static int lifting = -500;
    public static double pow = 0.1;

    @Override
    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);

        sleep(500);
        robot.getElevator().reset(pow);



    }
}

