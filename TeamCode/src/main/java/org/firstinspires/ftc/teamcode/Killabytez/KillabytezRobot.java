package org.firstinspires.ftc.teamcode.Killabytez;

import com.acmerobotics.roadrunner.drive.Drive;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class KillabytezRobot {

    HardwareMap hardwareMap;
    DriveTrain drivetrain;
    Claw claw;
    Elevator elevator;
    Extender extender;

    public KillabytezRobot() {
    }

    public void init(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
        Claw claw=new Claw(hardwareMap);
        DriveTrain drivetrain=new DriveTrain(hardwareMap);
        Elevator elevator=new Elevator(hardwareMap);
        Extender extender=new Extender(hardwareMap);
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
