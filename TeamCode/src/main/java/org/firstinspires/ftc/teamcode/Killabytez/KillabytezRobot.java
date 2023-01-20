package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class KillabytezRobot {

    HardwareMap hardwareMap;
    DriveTrain drivetrain;
    Elevator elevator;
    Extender extender;

    Bucket bucket;
    VirtualFourBar v4b;

    public KillabytezRobot() {
    }

    public void init(HardwareMap hardwareMap) {
        this.hardwareMap=hardwareMap;
    //    claw=new Claw(hardwareMap);
      //  claw.init();

   //     bicep=new Bicep(hardwareMap);
   //     bicep.init();

        drivetrain=new DriveTrain(hardwareMap);
        drivetrain.init();

        elevator=new Elevator(hardwareMap);
        elevator.init();

        extender=new Extender(hardwareMap);
        extender.init();

        v4b=new VirtualFourBar(hardwareMap);
        v4b.init();

        bucket=new Bucket(hardwareMap);
        bucket.init();
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

    public VirtualFourBar getV4b() {return v4b;}

    public Bucket getBucket() {return bucket;}
}
