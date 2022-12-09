package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;
import org.firstinspires.ftc.teamcode.Processors.BaseProcessor;
import org.firstinspires.ftc.teamcode.Processors.ClawTeleOpProcessor;
import org.firstinspires.ftc.teamcode.Processors.ElevatorTeleOpProcessor;
import org.firstinspires.ftc.teamcode.Processors.ExtenderTeleOpProcessor;
import org.firstinspires.ftc.teamcode.Processors.MovementTeleOpProcessor;

import java.util.Arrays;
import java.util.List;

@TeleOp
public class BaseTeleOp extends LinearOpMode {
    public KillabytezRobot killabytezRobot;
  //  public Claw claw;
    List<BaseProcessor> teleOpProcessors;

    @Override
    public void runOpMode() {
        teleOpProcessors = Arrays.asList(
                new ElevatorTeleOpProcessor(this),
                new ExtenderTeleOpProcessor(this),
                new ClawTeleOpProcessor(this),
                new MovementTeleOpProcessor(this)
        );
        killabytezRobot=new KillabytezRobot();
        killabytezRobot.init(hardwareMap);

        for(BaseProcessor processor: teleOpProcessors) {
            processor.init();
        }

       // claw = new Claw(hardwareMap);
        while (opModeIsActive()) {
            for(BaseProcessor processor: teleOpProcessors) {
                processor.process();
                sleep(50);
            }
        }
    }

    public KillabytezRobot getKillabytezRobot() {
        return killabytezRobot;
    }
}
