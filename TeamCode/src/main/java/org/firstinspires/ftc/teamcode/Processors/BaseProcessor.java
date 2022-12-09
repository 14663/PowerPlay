package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.BaseTeleOp;
import org.firstinspires.ftc.teamcode.Killabytez.KillabytezRobot;

public abstract class BaseProcessor implements Processor {

    protected LinearOpMode opMode;

    private ElapsedTime runtime = new ElapsedTime();

    BaseProcessor(LinearOpMode opMode) {
        this.opMode = opMode;

    }

    public KillabytezRobot getKillabytezRobot() {

        // TODO:  Hack for now
        return ((BaseTeleOp) opMode).getKillabytezRobot();
    }

    protected Telemetry getTelemetry() {

        return opMode.telemetry;

    }

    protected Gamepad getGamepad(int i) {

        return (i == 1) ? opMode.gamepad1 : opMode.gamepad2;

    }


    protected void sleep(long msec) {

        opMode.sleep(msec);

    }


    abstract public void init();

    abstract public void process();

    /*public void encoderDrive(double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftTarget;
        int newRightTarget;

        // Ensure that the opmode is still active
        // Determine new target position, and pass to motor controller
        double fudge_factor = 1.0;
        if (leftInches == rightInches) {
            fudge_factor = FUDGE_FACTOR;
        }
        newLeftTarget = getHardwarePushbot().leftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH * fudge_factor);
        newRightTarget = getHardwarePushbot().rightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH * fudge_factor);

        getHardwarePushbot().leftDrive.setTargetPosition(newLeftTarget);
        getHardwarePushbot().rightDrive.setTargetPosition(newRightTarget);

        // Turn On RUN_TO_POSITION
        getHardwarePushbot().leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        getHardwarePushbot().rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // reset the timeout time and start motion.
        runtime.reset();
        getHardwarePushbot().leftDrive.setPower(Math.abs(0.5));
        getHardwarePushbot().rightDrive.setPower(Math.abs(0.5));

        // keep looping while we are still active, and there is time left, and both motors are running.
        // Note: We use (isBusy() && isBusy()) in the loop test, which means that when EITHER motor hits
        // its target position, the motion will stop.  This is "safer" in the event that the getHardwarePushbot() will
        // always end the motion as soon as possible.
        // However, if you require that BOTH motors have finished their moves before the getHardwarePushbot() continues
        // onto the next step, use (isBusy() || isBusy()) in the loop test.
        while ((getHardwarePushbot().leftDrive.isBusy() && getHardwarePushbot().rightDrive.isBusy())) {
            getTelemetry().update();
        }

        // Stop all motion;
        getHardwarePushbot().leftDrive.setPower(0);
        getHardwarePushbot().rightDrive.setPower(0);

        // Turn off RUN_TO_POSITION
        getHardwarePushbot().leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        getHardwarePushbot().rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        sleep(50);   // optional pause after each move
    }*/
}

