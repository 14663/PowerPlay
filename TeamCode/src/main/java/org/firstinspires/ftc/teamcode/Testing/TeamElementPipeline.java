package org.firstinspires.ftc.teamcode.Testing;

import static org.firstinspires.ftc.teamcode.util.Constants.*;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

public class TeamElementPipeline extends OpenCvPipeline {

    Telemetry telemetry;
    Mat matY = new Mat();
    Mat region;
    int avg;
    Mat Cb = new Mat();
    PARKING_POSITION position;
    Point[] points;

    public TeamElementPipeline(Telemetry t){
        telemetry = t;
        points = POINTS;
    }

    private void inputToCb(Mat input) {
        Imgproc.cvtColor(input, matY, Imgproc.COLOR_RGB2YCrCb);
        Core.extractChannel(matY, Cb, 2);
    }

    @Override
    public void init(Mat input) {
        inputToCb(input);
        region = Cb.submat(new Rect(points[1], points[0]));
    }
    @Override
    public Mat processFrame(Mat input){
        inputToCb(input);

        avg = (int) Core.mean(region).val[0];

        Imgproc.cvtColor(input, matY, Imgproc.COLOR_RGB2YCrCb);
        Imgproc.rectangle(input, points[1], points[0], BLUE, 2);
        return input;
    }

    public PARKING_POSITION getAnalysis()
    {
        return position;
    }
    public int getAverage(){
        return avg;
    }
}
