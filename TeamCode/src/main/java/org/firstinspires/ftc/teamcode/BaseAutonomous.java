package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;
import org.firstinspires.ftc.teamcode.Processors.BaseProcessor;
import org.firstinspires.ftc.teamcode.Processors.Processor;

import java.util.Arrays;
import java.util.List;

//import org.firstinspires.ftc.teamcode.Processors.Latching_Auto_Processor;
//import org.firstinspires.ftc.teamcode.Processors.Latching_Processor;

public class BaseAutonomous extends LinearOpMode {
    public static KillabytezRobot hardwarePushbot = new KillabytezRobot();
    public boolean latchmode;
    public boolean depo;
    List<BaseProcessor> Autonomous_processors;

    KillabytezRobot killabytezRobot;

    public BaseAutonomous(boolean Depo) {
        this.depo = Depo;
    }

    public KillabytezRobot getKillabytezRobot() {
        return killabytezRobot;
    }

    @Override
    public void runOpMode() {
        hardwarePushbot.init(this.hardwareMap);
        Autonomous_processors = Arrays.asList(

        );


        for (Processor processor : Autonomous_processors) {
            processor.init();
        }

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Driver");    //

        telemetry.update();


        // Wait for the game to start (driver presses PLAY)

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


    public Processor getProcessors(Class clazz) {
        for (Processor processor : Autonomous_processors)
            if (clazz.isInstance(processor)) {
                return processor;
            }
        return null;
    }
}