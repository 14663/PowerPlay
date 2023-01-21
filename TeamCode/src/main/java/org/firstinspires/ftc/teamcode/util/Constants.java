package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.opencv.core.Point;
import org.opencv.core.Scalar;

public class Constants {
    //power
    public static final double noPow=0;

    //Defines encoder multipliers
    public static final double verticalRightMultiplier=1;
    public static final double verticalLeftMultiplier=1;
    public static final double horizontalMultiplier=1;

    //drive constants
    public static final double COUNTS_PER_MOTOR_REV = 8192;
    public static final double DRIVE_GEAR_REDUCTION = 1;
    public static final double WHEEL_DIAMETER_INCHES = 1.49606;

    //claw constants
    public static final double WRIST_OPEN=0.75;
    public static final double WRIST_CLOSED=0;

    //elevator constants
    public static final int LOW_ELEVATOR_HEIGHT = 0;
    public static final int MID_ELEVATOR_HEIGHT = 1100;
    public static final int HIGH_ELEVATOR_HEIGHT = 2300;
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
    public static final double LEFT_BICEP_OPEN=1;
    public static final double LEFT_BICEP_CLOSED=-0.87;
    public static final double RIGHT_BICEP_OPEN=-1;
    public static final double RIGHT_BICEP_CLOSED=0.87;

    public static final double CLASP_CLOSED=0.3;
    public static final double CLASP_OPEN=0;

    //28 * 20 / (2ppi * 4.125)
    public static final Double WIDTH = 13.0; //inches
    public static final Integer CPR = 28; //counts per rotation
    public static final Integer GEAR_RATIO = 20;
    public static final Double DIAMETER = 3.77;
    public static final Double CPI = (CPR * GEAR_RATIO)/(Math.PI * DIAMETER); //counts per inch, 28cpr * gear ratio / (2 * pi * diameter (in inches, in the center))
    public static final Double BIAS = 1.0;//default 0.8
    public static final Double MECCY_BIAS = 0.9;//change to adjust only strafing movement

    public static final int posHighElevator=1750;

    public static final int extenderOut=1000;

    public static final int openPosBucket = 0;
    public static final int closedPosBucket = 1;

    public static final double OpenLeftClaw = 1;
    public static final double OpenRightClaw = 0.5;

    public static final double CloseLeftClaw = 0.5;
    public static final double CloseRightClaw = 1;

    //
    public static final Double CONVERSION = CPI * BIAS;
    public static Boolean EXIT = false;
    //
    public static Orientation angles;
    public static Acceleration gravity;
    public static BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

    public static final int EXTENDER_OUT_TICKS=-1100;
    public static final double EXTENDER_OUT_POWER=0.8;
    public static final int EXTENDER_IN_TICKS=0;
    public static final double EXTENDER_IN_POWER=-1.0;

}
