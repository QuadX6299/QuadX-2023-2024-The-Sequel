package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@Autonomous(name = "SafteyPark", group = "Center Stage Autos")
public abstract class RunnerCode extends LinearOpMode {

    private LinearOpMode newOp;

    public SafteyParkAuto RunCode;

    public RunnerCode() {

        RunCode = new SafteyParkAuto();


    }

    public void init(LinearOpMode opMode) throws InterruptedException {
        newOp = opMode;

        waitForStart();
        RunCode.init(opMode);
        RunCode.Saftey_Park();

    }
}


