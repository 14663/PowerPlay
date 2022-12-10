package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.NORMAL_SPEED_CONSTANT_TELEOP;
import static org.firstinspires.ftc.teamcode.util.Constants.SLOW_SPEED_CONSTANT_TELEOP;

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
        if(getGamepad(1).left_bumper) getKillabytezRobot().getDrivetrain().setSpeedConstantTeleOp(SLOW_SPEED_CONSTANT_TELEOP);
        if(getGamepad(1).right_bumper) getKillabytezRobot().getDrivetrain().setSpeedConstantTeleOp(NORMAL_SPEED_CONSTANT_TELEOP);
    }
}
