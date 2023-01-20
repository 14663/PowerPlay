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
  //  public Claw claw;



    @Override
    public void init() {
        driveTrain = new DriveTrain(hardwareMap);
        elevator = new Elevator(hardwareMap);
        extender = new Extender(hardwareMap);
       // claw = new Claw(hardwareMap);
    }

    @Override
    public void loop() {

        driveTrain.drivingTeleop(
                gamepad1.left_stick_x,
                gamepad1.left_stick_y,
                gamepad1.right_stick_x);

        if (gamepad1.a)
            elevator.lifting(2400, 0.75);


        if (gamepad1.b)
            elevator.lifting(1100, 0.75);



        if (gamepad1.x)
            elevator.lifting(700, 0.75);


        if (gamepad1.y)
            elevator.reset(0.75);



        extender.extendingTeleop(gamepad1.left_trigger);

        extender.retractingTeleop(gamepad1.right_trigger);











    }
}
