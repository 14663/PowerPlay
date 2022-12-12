package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;
import org.firstinspires.ftc.teamcode.Processors.BaseProcessor;
import org.firstinspires.ftc.teamcode.Processors.Processor;
import org.firstinspires.ftc.teamcode.Processors.SafetyMovementAutoProcessor;

import java.util.Arrays;
import java.util.List;

@Autonomous(name="right", group="asdasd")
public class RightStrafeAuto extends LinearOpMode {

    KillabytezRobot killabytezRobot;
    List<BaseProcessor> Autonomous_processors;

    public RightStrafeAuto() {
        killabytezRobot=new KillabytezRobot();
    }

    public KillabytezRobot getKillabytezRobot() {
        return killabytezRobot;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        killabytezRobot.init(hardwareMap);

        Autonomous_processors = Arrays.asList(
            new SafetyMovementAutoProcessor(this, true)
        );


        for (Processor processor : Autonomous_processors) {
            processor.init();
        }
        waitForStart();

        // run until the end of the match (driver presses STOP)
        for (Processor processor : Autonomous_processors) {

            if (opModeIsActive()) {
                processor.process();
            }

            // Pace this loop so jaw action is reasonable speed.

            sleep(50);

            telemetry.update();
        }
    }
}
