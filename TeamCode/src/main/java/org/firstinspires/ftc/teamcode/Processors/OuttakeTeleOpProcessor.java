package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.ELEVATOR_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.HIGH_ELEVATOR_HEIGHT;
import static org.firstinspires.ftc.teamcode.util.Constants.LOW_ELEVATOR_HEIGHT;
import static org.firstinspires.ftc.teamcode.util.Constants.MID_ELEVATOR_HEIGHT;
import static org.firstinspires.ftc.teamcode.util.Constants.posHighElevator;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.Bucket;
import org.firstinspires.ftc.teamcode.Killabytez.Elevator;

public class OuttakeTeleOpProcessor extends BaseProcessor {
    public OuttakeTeleOpProcessor(LinearOpMode opMode) {
        super(opMode);
    }

    Elevator elevator;
    Bucket bucket;

    @Override
    public void init() {
        elevator=getKillabytezRobot().getElevator();
        bucket=getKillabytezRobot().getBucket();
        bucket.closeServo();
    }

    @Override
    public void process() {
        if(getGamepad(2).y) bucket.openServo();
        if(getGamepad(2).x) bucket.closeServo();
        if(getGamepad(2).right_stick_button) elevator.lifting(posHighElevator, 0.7);
        if(getGamepad(2).left_stick_button) elevator.reset(0.7);
        if(getGamepad(2).b) {
            elevator.lifting(posHighElevator, 0.7);
            bucket.openServo();
            sleep(500);
            bucket.closeServo();
            sleep(500);
            elevator.reset(0.7);
        }
    }
}
