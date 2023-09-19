package org.firstinspires.ftc.teamcode;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp()
public class KyExcersise extends OpMode {

    private DcMotor Motor1;
    @Override
    public void init() {
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        Motor1  = hardwareMap.get(DcMotor.class, "testMotor1");

    }

        public void loop() {
        int teamNumber = 16072;
        double motorSpeed = 0.5;
        boolean touchSensorPressed = true;
        telemetry.addData("Team2", teamNumber);
        telemetry.addData("Motor Speed", motorSpeed);
        telemetry.addData("Touch Sensor", touchSensorPressed);

        double speedForward = -gamepad1.left_stick_y / 2.0;
        if (gamepad1.left_stick_y < 0.5) {
            Motor1.setPower(1);
            telemetry.addData("Left stick", " is negative and large");
        }
        else if (gamepad1.left_stick_y < 0) {
            telemetry.addData("Left stick", " is negative and small");
        }
        else if (speedForward -gamepad1.left_stick_y < 0.5) {
            telemetry.addData("Left stick", " is positive and small");
        }
        else {
            telemetry.addData("Left stick", " is positive and large");
        }

        telemetry.addData("Left stick y", gamepad1.left_stick_y);
            telemetry.update();

    }

}



