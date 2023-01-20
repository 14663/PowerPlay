package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

@Config
@Autonomous
public class EncoderPID {
    /*

     * Proportional Integral Derivative Controller w/ Low pass filter and anti-windup

     */

    DcMotorEx motor;
    double Kp;
    double Ki;
    double Kd;
    double reference;
    double maxIntegralSum;
    private double errorTolerance;

    public EncoderPID(DcMotorEx motor, double kp, double ki, double kd, double reference, double maxIntegralSum, double errorTolerance) {
        this.motor = motor;
        Kp = kp;
        Ki = ki;
        Kd = kd;
        this.reference = reference;
        this.maxIntegralSum=maxIntegralSum;
        this.errorTolerance=errorTolerance;
    }

    private boolean setPointIsNotReached=false;

    private double lastReference = reference;
    private double integralSum = 0;

    private double lastError = 0;

    private double a = 0.8; // a can be anything from 0 < a < 1
    private double previousFilterEstimate = 0;
    private double currentFilterEstimate = 0;

    // Elapsed timer class from SDK, please use it, it's epic
    ElapsedTime timer = new ElapsedTime();

    public void run() {
        if(setPointIsNotReached!=true) {
            // obtain the encoder position
            double encoderPosition = motor.getCurrentPosition();
            // calculate the error
            double error = reference - encoderPosition;

            double errorChange = (error - lastError);

            // filter out hight frequency noise to increase derivative performance
            currentFilterEstimate = (a * previousFilterEstimate) + (1-a) * errorChange;
            previousFilterEstimate = currentFilterEstimate;

            // rate of change of the error
            double derivative = currentFilterEstimate / timer.seconds();

            // sum of all error over time
            integralSum = integralSum + (error * timer.seconds());


            // max out integral sum
            if (integralSum > maxIntegralSum) {
                integralSum = maxIntegralSum;
            }

            if (integralSum < -maxIntegralSum) {
                integralSum = -maxIntegralSum;
            }

            // reset integral sum upon setpoint changes
            if (reference != lastReference) {
                integralSum = 0;
            }

            double out = (Kp * error) + (Ki * integralSum) + (Kd * derivative);

            setPointIsNotReached(Math.abs(error)<errorTolerance);

            if(!setPointIsNotReached) motor.setPower(out);

            lastError = error;

            lastReference = reference;

            // reset the timer for next time
            timer.reset();
        }
    }

    private void setPointIsNotReached(boolean b) {
        setPointIsNotReached=b;
    }

    public boolean isSetPointIsNotReached() {
        return setPointIsNotReached;
    }
}
