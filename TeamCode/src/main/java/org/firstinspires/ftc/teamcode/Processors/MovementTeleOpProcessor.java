package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class MovementTeleOpProcessor extends BaseProcessor{
    public MovementTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        getKillabytezRobot().getDrivetrain().drivingTeleop(getGamepad(1).left_stick_x, getGamepad(1).left_stick_y, getGamepad(1).right_stick_x);
    }
}
