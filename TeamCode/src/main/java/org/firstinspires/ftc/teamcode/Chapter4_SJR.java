package com.acmerobotics.dashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
@TeleOp()
public class Chapter4_SJR extends OpMode {
    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
    }
    public void loop(){
        int teamNumber = 16072;
        double motorSpeed = 0.5;
        boolean touchSensorPressed = true;
        telemetry.addData("Team2B", teamNumber);
        telemetry.addData("Speed_of_Motor", motorSpeed);
        telemetry.addData("Touch_Sensor", touchSensorPressed);
        if (gamepad1.left_stick_y < -0.5) {
            telemetry.addData("Left_Stick", " negative_and_large");
        }
        else if (gamepad1.left_stick_y < 0) {
            telemetry.addData("Left_Stick", " negative_and_small");
        }
        else if (gamepad1.left_stick_y < 0.5) {
            telemetry.addData("Left_Stick", " positive_and_small");
        }
        else {
            telemetry.addData("Left_Stick", " positive_and_large");
        }
        telemetry.addData("Left_Stick_y", gamepad1.left_stick_y);
    }
}