package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="CalamityAuto", group="Auton")
public class CalamityAuto extends LinearOpMode {
    LinearOpMode op2 = this;
    HardwareCalamity robot   = new HardwareCalamity(this);

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {

        robot.init(hardwareMap);

        waitForStart();

        runtime.reset();

        while (opModeIsActive() && (runtime.seconds() < 3.0)) {
            robot.sleep(200);
            robot.FR.setPower(0.3);
            robot.FL.setPower(0.3);
            robot.BR.setPower(0.3);
            robot.BL.setPower(0.3);
        }
        robot.FR.setPower(0);
        robot.FL.setPower(0);
        robot.BR.setPower(0);
        robot.BL.setPower(0);
    }
}
