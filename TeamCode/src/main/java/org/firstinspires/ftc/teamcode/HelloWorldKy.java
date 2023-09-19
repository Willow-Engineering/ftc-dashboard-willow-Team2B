package org.firstinspires.ftc.teamcode;
import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
 @TeleOp()
 public class HelloWorldKy extends OpMode {
     @Override
     public void init() {

         FtcDashboard dashboard = FtcDashboard.getInstance();
         telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());

         telemetry.addData("Hello","WorldKY");
     }@Override
     public void loop() {
         }
}