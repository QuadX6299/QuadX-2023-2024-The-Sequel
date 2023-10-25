package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.TeleOpPower;
@TeleOp(name="BrokenTeleOp", group="Iterative Opmode")


public class TeleOpPowerRun extends TeleOpPower {
    @Override
    public void loop() {
        MechMove();
        telemetry.update();
    }
}