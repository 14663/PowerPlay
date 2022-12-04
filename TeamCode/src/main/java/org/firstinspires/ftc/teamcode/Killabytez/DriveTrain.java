package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class DriveTrain {
    public DcMotor bl, br, fl, fr;

    public DriveTrain(HardwareMap hardwareMap) {
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
    }
    public void drivingTeleop(float gamepadleftx, float gamepadlefty, float gamepadrightx) {
        float strafe = gamepadleftx;
        float turn = gamepadrightx;
        float drive = gamepadlefty;

        double FR = +strafe + drive + turn;
        double FL = -strafe + drive - turn;
        double BR = -strafe + drive + turn;
        double BL = +strafe + drive - turn;

        fr.setPower(FR);
        fl.setPower(FL);
        br.setPower(BR);
        bl.setPower(BL);


    }
}
