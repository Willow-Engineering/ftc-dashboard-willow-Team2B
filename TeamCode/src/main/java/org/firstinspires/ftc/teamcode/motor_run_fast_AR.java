package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp
public class motor_run_fast_AR extends OpMode {

    private DcMotor Motor1;

    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        Motor1  = hardwareMap.get(DcMotor.class, "motor1");


    }

    @Override
    public void loop() {

        if (gamepad1.a) // turbo mode
        {
            Motor1.setPower(1);
        }

        telemetry.update();
    }
}