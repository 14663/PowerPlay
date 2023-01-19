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

    double Kp;
    double Ki;
    double Kd;
    double reference;
    double maxIntegralSum;

    public EncoderPID(DcMotorEx motor, double kp, double ki, double kd, double reference, double maxIntegralSum) {
        this.motor = motor;
        Kp = kp;
        Ki = ki;
        Kd = kd;
        this.reference = reference;
        this.maxIntegralSum=maxIntegralSum;
    }

    DcMotorEx motor;

    boolean setPointIsNotReached=false;

    double lastReference = reference;
    double integralSum = 0;

    double lastError = 0;

    double a = 0.8; // a can be anything from 0 < a < 1
    double previousFilterEstimate = 0;
    double currentFilterEstimate = 0;

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

            motor.setPower(out);

            lastError = error;

            lastReference = reference;

            // reset the timer for next time
            timer.reset();

        }
    }

}
