package org.firstinspires.ftc.teamcode.Processors;

import static org.firstinspires.ftc.teamcode.util.Constants.CONVERSION;
import static org.firstinspires.ftc.teamcode.util.Constants.CPI;
import static org.firstinspires.ftc.teamcode.util.Constants.EXIT;
import static org.firstinspires.ftc.teamcode.util.Constants.MECCY_BIAS;
import static org.firstinspires.ftc.teamcode.util.Constants.angles;
import static org.firstinspires.ftc.teamcode.util.Constants.gravity;
import static org.firstinspires.ftc.teamcode.util.Constants.noPow;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.Killabytez.DriveTrain;

public class SafetyMovementAutoProcessor extends BaseProcessor {
    boolean right;
    public SafetyMovementAutoProcessor(LinearOpMode opMode, boolean right) {
        super(opMode);
        this.right=right;
    }

    DcMotor backleft, frontleft, backright, frontright;

    @Override
    public void init() {
        backleft=getKillabytezRobot().getDrivetrain().getWheel(DriveTrain.Wheel.BL);
        backright=getKillabytezRobot().getDrivetrain().getWheel(DriveTrain.Wheel.BR);
        frontleft=getKillabytezRobot().getDrivetrain().getWheel(DriveTrain.Wheel.FL);
        frontright=getKillabytezRobot().getDrivetrain().getWheel(DriveTrain.Wheel.FR);
    }

    @Override
    public void process() {
        strafeToPosition(30, right?0.5:-0.5);
    }

    public void moveToPosition(double inches, double speed){
        //
        int move = (int)(Math.round(inches*CONVERSION));
        //
        backleft.setTargetPosition(backleft.getCurrentPosition() + move);
        frontleft.setTargetPosition(frontleft.getCurrentPosition() + move);
        backright.setTargetPosition(backright.getCurrentPosition() + move);
        frontright.setTargetPosition(frontright.getCurrentPosition() + move);
        //
        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //
        frontleft.setPower(speed);
        backleft.setPower(speed);
        frontright.setPower(speed);
        backright.setPower(speed);
        //
        while (frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){
            if (EXIT){
                frontright.setPower(noPow);
                frontleft.setPower(noPow);
                backright.setPower(noPow);
                backleft.setPower(noPow);
                return;
            }
        }
        frontright.setPower(noPow);
        frontleft.setPower(noPow);
        backright.setPower(noPow);
        backleft.setPower(noPow);
        return;
    }
    //

    public void turnWithGyro(double degrees, double speedDirection){
        //<editor-fold desc="Initialize">
        angles  = getKillabytezRobot().getDrivetrain().getImu().getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
        double yaw = -angles.firstAngle;//make this negative
        getTelemetry().addData("Speed Direction", speedDirection);
        getTelemetry().addData("Yaw", yaw);
        getTelemetry().update();
        //
        getTelemetry().addData("stuff", speedDirection);
        getTelemetry().update();
        //
        double first;
        double second;

        if (speedDirection > 0){
            if (degrees > 10){
                first = (degrees - 10) + devertify(yaw);
                second = degrees + devertify(yaw);
            }else{
                first = devertify(yaw);
                second = degrees + devertify(yaw);
            }
        }else{
            if (degrees > 10){
                first = devertify(-(degrees - 10) + devertify(yaw));
                second = devertify(-degrees + devertify(yaw));
            }else{
                first = devertify(yaw);
                second = devertify(-degrees + devertify(yaw));
            }
            //
        }
        //
        Double firsta = convertify(first - 5);//175
        Double firstb = convertify(first + 5);//-175
        //
        turnWithEncoder(speedDirection);
        //
        if (Math.abs(firsta - firstb) < 11) {
            while (!(firsta < yaw && yaw < firstb) && opMode.opModeIsActive()) {//within range?
                angles = getKillabytezRobot().getDrivetrain().getImu().getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
                gravity = getKillabytezRobot().getDrivetrain().getImu().getGravity();
                yaw = -angles.firstAngle;
                getTelemetry().addData("Position", yaw);
                getTelemetry().addData("first before", first);
                getTelemetry().addData("first after", convertify(first));
                getTelemetry().update();
            }
        }else{
            //
            while (!((firsta < yaw && yaw < 180) || (-180 < yaw && yaw < firstb)) && opMode.opModeIsActive()) {//within range?
                angles = getKillabytezRobot().getDrivetrain().getImu().getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
                gravity = getKillabytezRobot().getDrivetrain().getImu().getGravity();
                yaw = -angles.firstAngle;
                getTelemetry().addData("Position", yaw);
                getTelemetry().addData("first before", first);
                getTelemetry().addData("first after", convertify(first));
                getTelemetry().update();
            }
        }
        //
        Double seconda = convertify(second - 5);//175
        Double secondb = convertify(second + 5);//-175
        //
        turnWithEncoder(speedDirection / 3);
        //
        if (Math.abs(seconda - secondb) < 11) {
            while (!(seconda < yaw && yaw < secondb) && opMode.opModeIsActive()) {//within range?
                angles = getKillabytezRobot().getDrivetrain().getImu().getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
                gravity = getKillabytezRobot().getDrivetrain().getImu().getGravity();
                yaw = -angles.firstAngle;
                getTelemetry().addData("Position", yaw);
                getTelemetry().addData("second before", second);
                getTelemetry().addData("second after", convertify(second));
                getTelemetry().update();
            }
            while (!((seconda < yaw && yaw < 180) || (-180 < yaw && yaw < secondb)) && opMode.opModeIsActive()) {//within range?
                angles = getKillabytezRobot().getDrivetrain().getImu().getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
                gravity = getKillabytezRobot().getDrivetrain().getImu().getGravity();
                yaw = -angles.firstAngle;
                getTelemetry().addData("Position", yaw);
                getTelemetry().addData("second before", second);
                getTelemetry().addData("second after", convertify(second));
                getTelemetry().update();
            }
            frontleft.setPower(noPow);
            frontright.setPower(noPow);
            backleft.setPower(noPow);
            backright.setPower(noPow);
        }
        //
        frontleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backleft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backright.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    //

    public void strafeToPosition(double inches, double speed){
        //
        int move = (int)(Math.round(inches * CPI * MECCY_BIAS));
        //
        backleft.setTargetPosition(backleft.getCurrentPosition() - move);
        frontleft.setTargetPosition(frontleft.getCurrentPosition() + move);
        backright.setTargetPosition(backright.getCurrentPosition() + move);
        frontright.setTargetPosition(frontright.getCurrentPosition() - move);
        //
        frontleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backleft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backright.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        //
        frontleft.setPower(speed);
        backleft.setPower(speed);
        frontright.setPower(speed);
        backright.setPower(speed);
        //
        while (frontleft.isBusy() && frontright.isBusy() && backleft.isBusy() && backright.isBusy()){}
        frontright.setPower(noPow);
        frontleft.setPower(noPow);
        backright.setPower(noPow);
        backleft.setPower(noPow);
        return;
    }
    //

    public void waitForStartify(){
        opMode.waitForStart();
    }
    //

    public double devertify(double degrees){
        if (degrees < 0){
            degrees = degrees + 360;
        }
        return degrees;
    }
    public double convertify(double degrees){
        if (degrees > 179){
            degrees = -(360 - degrees);
        } else if(degrees < -180){
            degrees = 360 + degrees;
        } else if(degrees > 360){
            degrees = degrees - 360;
        }
        return degrees;
    }
    //

    public void turnWithEncoder(double input){
        frontleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backleft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backright.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //
        frontleft.setPower(input);
        backleft.setPower(input);
        frontright.setPower(-input);
        backright.setPower(-input);
    }
}
