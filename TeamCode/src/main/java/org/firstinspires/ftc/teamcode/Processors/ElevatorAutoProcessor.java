package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.ELEVATOR_POWER;
import static org.firstinspires.ftc.teamcode.util.Constants.HIGH_ELEVATOR_HEIGHT;
import static org.firstinspires.ftc.teamcode.util.Constants.LOW_ELEVATOR_HEIGHT;
import static org.firstinspires.ftc.teamcode.util.Constants.MID_ELEVATOR_HEIGHT;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class ElevatorAutoProcessor extends BaseProcessor{

    ElevatorHeight elevatorHeight;

    ElevatorAutoProcessor(LinearOpMode opMode, ElevatorHeight elevatorHeight) {
        super(opMode);
        this.elevatorHeight=elevatorHeight;
    }

    public enum ElevatorHeight {
        LOW,
        MID,
        HIGH
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        switch(elevatorHeight) {
            case LOW: getKillabytezRobot().getElevator().lifting(LOW_ELEVATOR_HEIGHT, ELEVATOR_POWER);
            case MID: getKillabytezRobot().getElevator().lifting(MID_ELEVATOR_HEIGHT, ELEVATOR_POWER);
            case HIGH: getKillabytezRobot().getElevator().lifting(HIGH_ELEVATOR_HEIGHT, ELEVATOR_POWER);
        }
    }
}
