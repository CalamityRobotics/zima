package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
@TeleOp
public class CalamityTeleOp extends OpMode {
    // Init

    HardwareCalamity robot = new HardwareCalamity(this);
    boolean toggleSpin1, toggleTrapdoor1, toggleDeposit, toggleWrist1 = true;
    boolean toggleSpin2, toggleTrapdoor2, togglePickup, toggleWrist2 = false;
    @Override
    public void init() {
        robot.init(hardwareMap);
        robot.initMotors();
////        robot.rightLift.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
////        robot.leftLift.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        robot.arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//
////        robot.rightLift.setTargetPosition(0);
////        robot.leftLift.setTargetPosition(0);
//        robot.arm.setTargetPosition(0);
//
////        robot.rightLift.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
////        robot.leftLift.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//        robot.arm.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
    }

    //Main Code
    @Override
    public void loop() {

        //Functions


        // Driving

        if (gamepad1.left_stick_button) {
            robot.FR.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x);
            robot.FL.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x);
            robot.BR.setPower(-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x);
            robot.BL.setPower(-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x);
        } else {
            robot.FR.setPower(0.7 * (-gamepad1.left_stick_y - gamepad1.left_stick_x - gamepad1.right_stick_x));
            robot.FL.setPower(0.7 * (-gamepad1.left_stick_y + gamepad1.left_stick_x + gamepad1.right_stick_x));
            robot.BR.setPower(0.7 * (-gamepad1.left_stick_y + gamepad1.left_stick_x - gamepad1.right_stick_x));
            robot.BL.setPower(0.7 * (-gamepad1.left_stick_y - gamepad1.left_stick_x + gamepad1.right_stick_x));
        }

//        if (gamepad1.right_stick_y > 0.8) {
//            robot.arm.setPower(1);
//        } else if (gamepad1.right_stick_y < -0.8) {
//            robot.arm.setPower(-1);
//        } else {
//            robot.setLiftPower(0);
//        }

        if (gamepad1.a && toggleSpin1 == true) {
            toggleSpin2 = !toggleSpin2;
            robot.spin.setPower(toggleSpin2 ? 0 : 1);
            toggleSpin1 = false;
        } else if (!gamepad1.a) {
            toggleSpin1 = true;
        }

        if (gamepad1.b && toggleTrapdoor1 == true) {
            toggleTrapdoor2 = !toggleTrapdoor2;
            robot.trapdoor.setPosition(toggleTrapdoor2 ? 0 : 1);
            toggleTrapdoor1 = false;
        } else if (!gamepad1.b){
            toggleTrapdoor1 = true;
        }



        if (gamepad1.y && toggleDeposit == true) {
            togglePickup = !togglePickup;
            robot.sleep(500);
            toggleDeposit = false;
        } else if (!toggleDeposit) {
            toggleDeposit = true;
        }

        if (gamepad1.x && toggleWrist1 == true) {
            toggleWrist2 = !toggleWrist2;
            robot.sleep(300);
            robot.wrist1.setPosition(toggleWrist2 ? 0 : 1);
//            robot.wrist2.setPosition(toggleWrist2 ? 0 : 0.5);
            toggleWrist1 = false;
        } else if (!gamepad1.b){
            toggleWrist1 = true;
        }

//        if (gamepad1.right_bumper) {
//            robot.arm.setTargetPosition(1000);
//            robot.arm.setPower(1);
//        }
//
//        if (gamepad1.left_bumper) {
//            robot.arm.setTargetPosition(-1000);
//            robot.arm.setPower(-1);
//        }


//        if (gamepad1.right_bumper) {
//            robot.setLiftPower(0.2);
//        } else if (gamepad1.left_bumper) {
//            robot.setLiftPower(-0.2);
//        } else {
//            robot.setLiftPower(0);
//        }


        if (gamepad1.dpad_up) {
            robot.drone.setPosition(1);
        } else {
            robot.drone.setPosition(0);
        }

        robot.arm.setPower(gamepad1.right_trigger);
        robot.arm.setPower(-gamepad1.left_trigger);


        telemetry.addData("arm encoder pos", robot.arm.getCurrentPosition());

        telemetry.update();

    }

}
