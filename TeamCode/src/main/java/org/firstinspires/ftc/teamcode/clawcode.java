package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp(name="clawcode")
@Config

public class clawcode extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private Servo rightServo = null;
    private Servo leftServo = null;

    public static double rightServoPosOpen = 30;
    public static double leftServoPosOpen = 0;
    public static double rightServoPosClose = 0;
    public static double leftServoPosClose = 20;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.addData(">>", "Press start to continue");
        telemetry.update();

        rightServo = hardwareMap.get(Servo.class, "rightServo");
        leftServo = hardwareMap.get(Servo.class, "leftServo");

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            if (gamepad1.dpad_up) {
                rightServo.setPosition(rightServoPosOpen);
                leftServo.setPosition(leftServoPosOpen);
            }
            if (gamepad1.dpad_down) {
                rightServo.setPosition(rightServoPosClose);
                leftServo.setPosition(leftServoPosClose);

            }
            telemetry.update();
        }
    }
}

