package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.CRServo;


import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

//import org.first-inspires.ftc.robot controller.external.samples.SampleRevBlinkingLedDriver;

public abstract class TeleOpPower extends OpMode {

    private DcMotor Intake;
    private DcMotor fl;
    private DcMotor fr;
    private DcMotor bl;
    private DcMotor br;
    //private CRServo Lazy;

    LinearOpMode opMode;
    Orientation angles;
    Acceleration gravity;
    BNO055IMU.Parameters parameters;
    //DigitalChannel digitalTouch;
    double initT;

    //@Override
    public void init() {
        // MOTOR INITIALIZATION
        Intake = hardwareMap.dcMotor.get("intake");
        fl = hardwareMap.dcMotor.get("fl");
        fr = hardwareMap.dcMotor.get("fr");
        bl = hardwareMap.dcMotor.get("bl");
        br = hardwareMap.dcMotor.get("br");

        // Normally, should be two reversed, two forward. Reasoning as to why this works is unknown at the time.
        fl.setDirection(DcMotor.Direction.REVERSE);
        fr.setDirection(DcMotor.Direction.FORWARD);
        bl.setDirection(DcMotor.Direction.REVERSE);
        br.setDirection(DcMotor.Direction.FORWARD);
        Intake.setDirection(DcMotorSimple.Direction.FORWARD);

        fl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        fr.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        bl.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        br.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        //double value = 0;
    }

    public void MechMove() {
        float drive = gamepad1.left_stick_y;
        float statturn = gamepad1.left_stick_x;
        float turn = gamepad1.right_stick_x;


        double flPower = Range.clip(drive + turn + statturn, -1.0, 1.0);
        double frPower = Range.clip(drive - turn - statturn, -1.0, 1.0);
        double blPower = Range.clip(drive + turn - statturn, -1.0, 1.0);
        double brPower = Range.clip(drive - turn + statturn, -1.0, 1.0);



        if (gamepad1.right_trigger > 0.0) {
            flPower = 0.35;
            blPower = 0.35;
            frPower = 0.35;
            brPower = 0.35;
        }

        if (gamepad1.left_trigger > 0.0) {
            flPower *= .7;
            blPower *= .7;
            frPower *= .7;
            brPower *= .7;
        }

        if (gamepad1.a){
            Intake.setPower(1);
        }
        if (!gamepad1.a){
            Intake.setPower(0);
        }

        fl.setPower(flPower);
        fr.setPower(frPower);
        bl.setPower(blPower);
        br.setPower(brPower);
    }
}

