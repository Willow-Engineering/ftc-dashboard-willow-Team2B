/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.alexstuff;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When a selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="Basic_Bot_AR2")
@Config
//@Disabled
public class Basic_Bot_ARalex extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();

    private DcMotorEx Arm = null;
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private Servo rightServo = null;
    private Servo leftServo = null;


    private DistanceSensor sensorRange;

    public static double rightServoPosOpen = 10;
    public static double leftServoPosOpen = -10;
    public static double rightServoPosClose = 0;
    public static double leftServoPosClose = 20;
    public static double rightServoPosOpen2 = 0;
    public static double leftServoPosOpen2 = 20;
    public static int ArmPosition = -500;
    public static int ArmPosition2 = -10;
    public static int ArmPosition3 = -200;
    private static double distance;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.addData(">>", "Press start to continue");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        Arm = hardwareMap.get(DcMotorEx.class, "Arm");
        leftDrive = hardwareMap.get(DcMotor.class, "leftDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "rightDrive");
        rightServo = hardwareMap.get(Servo.class, "rightServo");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        sensorRange = hardwareMap.get(DistanceSensor.class, "sensorRange");

        // To drive forward, most robots need the motor on one side to be reversed, because the axles point in opposite directions.
        // Pushing the left stick forward MUST make robot go forward. So adjust these two lines based on your first test drive.
        // Note: The settings here assume direct drive on left and right wheels.  Gear Reduction or 90 Deg drives may require direction flips
        leftDrive.setDirection(DcMotor.Direction.REVERSE);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();
        Arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FtcDashboard dashboard = FtcDashboard.getInstance();
        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
        boolean test = false;

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double ArmPower = 0;
            double leftPower;
            double rightPower;
            double distance = sensorRange.getDistance(DistanceUnit.MM);


            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.

            double drive = gamepad1.left_stick_y;
            double turn = -gamepad1.right_stick_x;

            leftPower = Range.clip(drive + turn, -1.0, 1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
//            if(gamepad1.left_bumper){
//                ArmPower = 0.4;
//            }
//            else if(gamepad1.right_bumper) {
//                ArmPower = -0.4;
//            }
//            else{
//                ArmPower = 0;
//
//            }
            if (gamepad1.dpad_up) {
                rightServo.setPosition(rightServoPosOpen);
                leftServo.setPosition(leftServoPosOpen);
            }
            if (gamepad1.dpad_down) {
                rightServo.setPosition(rightServoPosClose);
                leftServo.setPosition(leftServoPosClose);

            }
            if (gamepad1.a) {
                Arm.setTargetPosition(ArmPosition);
                Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Arm.setVelocity(300);
            }
            if (gamepad1.b) {
                Arm.setTargetPosition(ArmPosition2);
                Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Arm.setVelocity(300);
            }
            if (gamepad1.y) {
                Arm.setTargetPosition(ArmPosition3);
                Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Arm.setVelocity(300);
            }
            if (gamepad1.left_bumper) {
                Arm.setTargetPosition(Arm.getCurrentPosition() + 10);
                Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Arm.setVelocity(300);
            }
            if (gamepad1.right_bumper) {
                Arm.setTargetPosition(Arm.getCurrentPosition() - 10);
                Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Arm.setVelocity(300);
            }
            if (gamepad1.left_trigger > 0) {
                Arm.setTargetPosition(Arm.getCurrentPosition() + 25);
                Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Arm.setVelocity(300);
            }
            if (gamepad1.right_trigger > 0) {
                Arm.setTargetPosition(Arm.getCurrentPosition() - 25);
                Arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
                Arm.setVelocity(300);
            }

//
//                 leftPower  = -gamepad1.left_stick_y ;
//                 rightPower = -gamepad1.right_stick_y ;
//
//                 Send calculated power to wheels
//                Arm.setPower(ArmPower);


            // leftPower  = -gamepad1.left_stick_y ;
            // rightPower = -gamepad1.right_stick_y ;

            // Send calculated power to wheels
            //Arm.setPower(ArmPower);


         if(gamepad1.x) {
             if (distance < 80) {
                 rightServo.setPosition(rightServoPosClose);
                 leftServo.setPosition(leftServoPosClose);
             }
         }
            leftDrive.setPower(leftPower);
            rightDrive.setPower(rightPower);
            telemetry.addData("dpad", gamepad1.dpad_up);

            // Show the elapsed game time and wheel power.
            telemetry.addData("deviceName", sensorRange.getDeviceName());
            telemetry.addData("range", String.format("%.01f m", sensorRange.getDistance(DistanceUnit.MM)));

            // Rev2mDistanceSensor specific methods.
            // telemetry.addData("Rev2mDistanceSensor",((Rev2mDistanceSensor) sensorRange).getDeviceClient());
            telemetry.addData("Current Arm Position", Arm.getCurrentPosition());
            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.addData("Is it close?", test);
            telemetry.update();


        }
    }
}


