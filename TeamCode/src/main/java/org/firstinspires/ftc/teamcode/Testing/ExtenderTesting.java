package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Killabytez.Extender;

@Config
@Autonomous
public class ExtenderTesting extends LinearOpMode {

    Extender extender;
    public static int lifting = 500;

    @Override
    public void runOpMode() throws InterruptedException {
        extender = new Extender(hardwareMap);

        extender.extending(lifting,0.75);
        sleep(10000);
        extender.reset(1);

    }
}
