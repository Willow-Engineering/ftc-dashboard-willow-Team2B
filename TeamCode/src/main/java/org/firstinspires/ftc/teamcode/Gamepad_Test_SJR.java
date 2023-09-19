package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;

@TeleOp()
;\public class amepad_Test_SJR extends OpMode {
    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
    }

    @Override
    public void loop() {
        telemetry.addData("R_stick_x", gamepad1.right_stick_x);
        telemetry.addData("R_stick_y", gamepad1.right_stick_y);
        telemetry.addData("B_button", gamepad1.b);
        telemetry.addData("Difference_Sticks", gamepad1.left_stick_y - gamepad1.right_stick_y);
        telemetry.addData( "Sum_Trigger", gamepad1.left_trigger + gamepad1.right_trigger);

    }