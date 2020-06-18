package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="DriverControl", group="boundless")
public class DriverControl extends LinearOpMode {
    //initiating motors
    private DcMotor frontLeft;
    private DcMotor frontRight;
    //private DcMotor backLeft;
    //private DcMotor backRight;
    //private DcMotor m1,m2,m3,m4; //these motors will be used for other things
    public void runOpMode(){
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight  = hardwareMap.get(DcMotor.class, "frontRight");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        double fbLeftStick=0;
        //double lrLeftStick=0;
        //double lrRightStick=0;
        double fbRightStick=0;
        frontRight.setDirection(DcMotor.Direction.REVERSE);

        //put all movement code in here
        while(opModeIsActive()){
            fbLeftStick = -this.gamepad1.left_stick_y;
            fbRightStick = -this.gamepad1.right_stick_y;
            //lrLeftStick = -this.gamepad1.left_stick_x; //if turning the wrong direction reverse the sign
            //lrRightStick = -this.gamepad1.right_stick_x; //if turning the wrong direction reverse the sign

            tank(fbLeftStick, fbRightStick);
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
    }
    public void tank(double fbLeftStick, double fbRightStick){
        frontLeft.setPower(fbLeftStick);
        frontRight.setPower(fbRightStick);
        telemetry.addData("Target Power", fbLeftStick);
        telemetry.addData("Target Power", fbRightStick);
        telemetry.addData("Motor Power", frontLeft.getPower());
        telemetry.addData("Motor Power", frontRight.getPower());

    }
    public void movingFB(double fbLeftStick){

        frontLeft.setPower(fbLeftStick);
        frontRight.setPower(fbLeftStick);
        telemetry.addData("Target Power", fbLeftStick);
        telemetry.addData("Motor Power", frontLeft.getPower());
        telemetry.addData("Motor Power", frontRight.getPower());
    }
    public void strafe(double lrLeftStick){

        frontLeft.setPower(lrLeftStick);
        frontRight.setPower(-lrLeftStick);
        telemetry.addData("Target Power", lrLeftStick);
        telemetry.addData("Motor Power", frontLeft.getPower());
        telemetry.addData("Motor Power", frontRight.getPower());
    }
    public void turn(double lrRightStick) {

        frontLeft.setPower(lrRightStick);
        frontRight.setPower(-lrRightStick);
        telemetry.addData("Target Power", lrRightStick);
        telemetry.addData("Motor Power", frontLeft.getPower());
        telemetry.addData("Motor Power", frontRight.getPower());
    }
}