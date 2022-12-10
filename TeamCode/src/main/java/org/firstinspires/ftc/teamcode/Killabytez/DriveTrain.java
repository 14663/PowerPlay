package org.firstinspires.ftc.teamcode.Killabytez;

import static org.firstinspires.ftc.teamcode.util.Constants.parameters;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class DriveTrain {
    private DcMotor bl, br, fl, fr;
    private HardwareMap hardwareMap;
    private double speedConstantTeleOp =1;
    private BNO055IMU imu;

    public enum Wheel {
        BL, BR, FL, FR;
    }

    public DriveTrain(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
    }

    public void init() {
        bl = hardwareMap.get(DcMotor.class, "bl");
        br = hardwareMap.get(DcMotor.class, "br");
        fl = hardwareMap.get(DcMotor.class, "fl");
        fr = hardwareMap.get(DcMotor.class, "fr");

        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        br.setDirection(DcMotor.Direction.FORWARD);
        fr.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.REVERSE);
        fl.setDirection(DcMotor.Direction.REVERSE);
        // Add IMU and set initial state to IDLE
        initGyro();
    }

    public void initGyro(){
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        //
        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);
    }

    public void drivingTeleop(float gamepadleftx, float gamepadlefty, float gamepadrightx) {
        float strafe = gamepadleftx;
        float turn = gamepadrightx;
        float drive = gamepadlefty;

        double FR = +strafe + drive + turn;
        double FL = -strafe + drive - turn;
        double BR = -strafe + drive + turn;
        double BL = +strafe + drive - turn;

        fr.setPower(FR* speedConstantTeleOp);
        fl.setPower(FL* speedConstantTeleOp);
        br.setPower(BR* speedConstantTeleOp);
        bl.setPower(BL* speedConstantTeleOp);
    }

    public void setSpeedConstantTeleOp(double speedConstantTeleOp) {
        this.speedConstantTeleOp = speedConstantTeleOp;
    }

    public BNO055IMU getImu() {
        return imu;
    }

    public DcMotor getWheel(Wheel wheel) {
        switch(wheel) {
            case BL: return bl;
            case BR: return br;
            case FL: return fl;
            case FR: return fr;
        }
        return null;
    }

}
