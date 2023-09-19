package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp()
public class Chapter4_AR extends OpMode {

    @Override
    public void init() {
    }
    @Override
    public void loop() {
        double speedForward = -gamepad1.left_stick_y / 2.0;
        telemetry.addData("Left stick y", gamepad1.left_stick_y);
        telemetry.addData("speed Forward", speedForward);
        if (gamepad1.a) {
            speedForward = 1;
            }
        else if (!gamepad1.a) {
            speedForward = 0.5;
        }
while (gamepad1.a) {
    telemetry.addData(gamepad1.left_stick_y = gamepad1.left_stick_x);
    telemetry.addData(gamepad1.left_stick_x = gamepad1.right_stick_y);
}
while (!gamepad1.a) {
    telemetry.addData(gamepad1.left_stick_y = gamepad1.left_stick_y);
    telemetry.addData(gamepad1.left_stick_x = gamepad1.left_stick_x);
}
        }
    }