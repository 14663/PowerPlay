package org.firstinspires.ftc.teamcode.Killabytez;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class KillabytezRobot {

    HardwareMap hardwareMap;
    DriveTrain drivetrain;
    Claw claw;
    Elevator elevator;
    Extender extender;
    Bicep bicep;

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

      //  v4b=new V4B(hardwareMap);
      //  v4b.init();

      ///  bucket=new Bucket(hardwareMap);
      // bucket.init();
    }

    public Bicep getBicep() {return bicep;}
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
