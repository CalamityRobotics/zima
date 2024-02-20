package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class HardwareCalamity {
    public DcMotorEx FR, FL, BR, BL, rightLift, leftLift, arm, winch;
    public CRServo spin;
    public Servo trapdoor, wrist1, wrist2,drone;
    private ElapsedTime waitTime = new ElapsedTime();
    LinearOpMode op;
    OpMode op2;

    public HardwareCalamity(LinearOpMode op) {
        this.op = op;
    }
    public HardwareCalamity(OpMode op2) {
        this.op2 = op2;
    }

    public void sleep(int milis){
        try {
            Thread.sleep(milis);
        } catch (Exception e){}
    }

    public void init(HardwareMap hwMap) {

        arm = hwMap.get(DcMotorEx.class, "arm");
        wrist1 = hwMap.get(Servo.class, "wrist1");
        wrist2 = hwMap.get(Servo.class, "wrist2");
        drone = hwMap.get(Servo.class, "drone");
        spin = hwMap.get(CRServo.class, "spin");
        trapdoor = hwMap.get(Servo.class, "trapdoor");
        rightLift = hwMap.get(DcMotorEx.class, "rightLift");
        leftLift = hwMap.get(DcMotorEx.class, "leftLift");

        FL = hwMap.get(DcMotorEx.class, "FL");
        FR = hwMap.get(DcMotorEx.class, "FR");
        BL = hwMap.get(DcMotorEx.class, "BL");
        BR = hwMap.get(DcMotorEx.class, "BR");

        rightLift.setDirection(DcMotorEx.Direction.FORWARD);
        leftLift.setDirection(DcMotorEx.Direction.FORWARD);
        arm.setDirection(DcMotorEx.Direction.FORWARD);
        spin.setDirection(CRServo.Direction.FORWARD);

        FL.setDirection(DcMotorEx.Direction.REVERSE);
        FR.setDirection(DcMotorEx.Direction.FORWARD);
        BR.setDirection(DcMotorEx.Direction.FORWARD);
        BL.setDirection(DcMotorEx.Direction.REVERSE);

        FL.setZeroPowerBehavior(BRAKE);
        FR.setZeroPowerBehavior(BRAKE);
        BR.setZeroPowerBehavior(BRAKE);
        BL.setZeroPowerBehavior(BRAKE);

        arm.setZeroPowerBehavior(BRAKE);
        leftLift.setZeroPowerBehavior(BRAKE);
        rightLift.setZeroPowerBehavior(BRAKE);

    }

    public void initMotors() {
        FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void setDrivePower(double left, double right) {
        FL.setPower(left);
        FR.setPower(right);
        BR.setPower(right);
        BL.setPower(left);
    }

    public void setLiftPower(double slide) {
        rightLift.setPower(slide);
        leftLift.setPower(slide);
    }


//    public void liftForCounts( int counts, double liftPower)
//    {
//        int slide1counts = 0, slide2counts = 0;
//
//        rightLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        leftLift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//        rightLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//        leftLift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
//
//        rightLift.setPower(liftPower);
//        leftLift.setPower(liftPower);
//
//        waitTime.reset();
//
//        while(op.opModeIsActive() && (Math.abs(slide1counts) < counts)) {
//            slide1counts = rightLift.getCurrentPosition();
//            slide2counts = leftLift.getCurrentPosition();
//        }
//        setLiftPower(0);
//
//    }

}
