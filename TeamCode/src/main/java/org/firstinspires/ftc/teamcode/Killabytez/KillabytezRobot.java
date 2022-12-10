package org.firstinspires.ftc.teamcode.Killabytez;

import com.acmerobotics.roadrunner.drive.Drive;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class KillabytezRobot {

    HardwareMap hardwareMap;
    DriveTrain drivetrain;
    Claw claw;
    Elevator elevator;
    Extender extender;
    Bicep bicep;

    public KillabytezRobot() {
    }

    public void init(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
        claw=new Claw(hardwareMap);
        claw.init();
        bicep=new Bicep(hardwareMap);
        bicep.init();
        drivetrain=new DriveTrain(hardwareMap);
        drivetrain.init();
        elevator=new Elevator(hardwareMap);
        elevator.init();
        extender=new Extender(hardwareMap);
        extender.init();
    }

    public Bicep getBicep() {
        return bicep;
    }
    public Claw getClaw() {
        return claw;
    }
    public DriveTrain getDrivetrain() {
        return drivetrain;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public Extender getExtender() {
        return extender;
    }
}
