package org.firstinspires.ftc.teamcode.Processors;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Killabytez.Bicep;
import org.firstinspires.ftc.teamcode.Killabytez.Bicep.BicepMode;

public class BicepAutoProcessor extends BaseProcessor {
    BicepMode bicepMode;

    BicepAutoProcessor(LinearOpMode opMode, BicepMode bicepMode) {
        super(opMode);
        this.bicepMode=bicepMode;
    }

    @Override
    public void init() {

    }

    @Override
    public void process() {
        switch(bicepMode) {
            case OPEN_BICEP: getKillabytezRobot().getBicep().openBicep();
            case CLOSED_BICEP: getKillabytezRobot().getBicep().closeBicep();
            case OPEN_CLASP: getKillabytezRobot().getBicep().openClasp();
            case CLOSED_CLASP: getKillabytezRobot().getBicep().closeClasp();
        }
    }
}
