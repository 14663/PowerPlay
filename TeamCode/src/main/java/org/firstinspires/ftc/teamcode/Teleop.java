package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Killabytez.DriveTrain;
import org.firstinspires.ftc.teamcode.Killabytez.Elevator;
import org.firstinspires.ftc.teamcode.Killabytez.Extender;

@TeleOp
public class Teleop extends OpMode {
    public DriveTrain driveTrain;
    public Elevator elevator;
    public Extender extender;


    @Override
    public void init() {
        driveTrain = new DriveTrain(hardwareMap);
        elevator = new Elevator(hardwareMap);
        extender = new Extender(hardwareMap);
    }

    @Override
    public void loop() {

        driveTrain.drivingTeleop(
                gamepad1.left_stick_x,
                gamepad1.left_stick_y,
                gamepad1.right_stick_x);

        if (gamepad1.a) {
            elevator.lifting(300, 0.75);
        }

        if (gamepad1.b) {
            elevator.reset(0.5);
        }







    }
}
