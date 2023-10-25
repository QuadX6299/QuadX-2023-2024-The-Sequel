package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


public class SafteyParkAuto{

    private LinearOpMode newOp;

    private DcMotor motorFL;
    private DcMotor motorBL;
    private DcMotor motorFR;
    private DcMotor motorBR;
    public void init(LinearOpMode opMode) throws InterruptedException {
        newOp = opMode;

        motorFL = opMode.hardwareMap.dcMotor.get("fl");
        motorBL = opMode.hardwareMap.dcMotor.get("bl");
        motorFR = opMode.hardwareMap.dcMotor.get("fr");
        motorBR = opMode.hardwareMap.dcMotor.get("br");

        motorFL.setDirection(DcMotor.Direction.FORWARD);
        motorFR.setDirection(DcMotor.Direction.FORWARD);
        motorBL.setDirection(DcMotor.Direction.FORWARD);
        motorBR.setDirection(DcMotor.Direction.REVERSE);

        motorFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    public void Saftey_Park()
    {
        motorFR.setPower(-1);
        motorFL.setPower(1);
        motorBR.setPower(1);
        motorBL.setPower(-1);

    }
}
