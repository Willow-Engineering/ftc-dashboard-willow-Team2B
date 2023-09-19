package org.firstinspires.ftc.teamcode.solutions;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class Chapter4_AR extends OpMode {
    @Override
    public void init() {
    }

    @Override
    public void loop() {
        double fwdSpeed = gamepad1.left_stick_y;

        if (!gamepad1.a) // turbo mode
        {
            fwdSpeed *= 0.5;
        }

        telemetry.addData("Forward Speed", fwdSpeed);
        double ySpeed = gamepad1.left_stick_y;
        double xSpeed = gamepad1.left_stick_x;

        if (gamepad1.a) { // crazy mode
            ySpeed = gamepad1.left_stick_x;
            xSpeed = gamepad1.left_stick_y;
        }

        telemetry.addData("Y Speed", ySpeed);
        telemetry.addData("X Speed", xSpeed);

    }
}

