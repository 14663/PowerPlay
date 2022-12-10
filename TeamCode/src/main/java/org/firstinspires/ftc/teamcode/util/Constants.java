package org.firstinspires.ftc.teamcode.util;

import org.opencv.core.Point;
import org.opencv.core.Scalar;

public class Constants {
    //Defines encoder multipliers
    public static final double verticalRightMultiplier=1;
    public static final double verticalLeftMultiplier=1;
    public static final double horizontalMultiplier=1;

    //drive constants
    public static final double COUNTS_PER_MOTOR_REV = 8192;
    public static final double DRIVE_GEAR_REDUCTION = 1;
    public static final double WHEEL_DIAMETER_INCHES = 1.49606;

    //claw constants
    public static final double CLAW_OPEN=0;
    public static final double CLAW_CLOSED=1;
    public static final double WRIST_OPEN=0;
    public static final double WRIST_CLOSED=1;

    //elevator constants
    public static final int LOW_ELEVATOR_HEIGHT = 0;
    public static final int MID_ELEVATOR_HEIGHT = 1100;
    public static final int HIGH_ELEVATOR_HEIGHT = 2400;
    public static final double ELEVATOR_POWER =0.75;

    //movement constants
    public static final double SLOW_SPEED_CONSTANT_TELEOP=0.7;
    public static final double NORMAL_SPEED_CONSTANT_TELEOP=1;


    public static final Point REGION1_TLEFT = new Point(75,195);
    public static final Point REGION1_BRIGHT = new Point(165,235);

    public static final Point[] POINTS = new Point[]{REGION1_BRIGHT, REGION1_TLEFT};

    public static final Scalar BLUE = new Scalar(0, 0, 255);
    public static final Scalar GREEN = new Scalar(0, 255, 0);
    public static final Scalar RED = new Scalar(255, 0, 0);

    public enum PARKING_POSITION {
        ONE,
        TWO,
        THREE
    }

    //bicep constants
    public static final double BICEP_OPEN=0;
    public static final double BICEP_CLOSED=1;
    public static final double CLASP_OPEN=0;
    public static final double CLASP_CLOSED=1;
}
