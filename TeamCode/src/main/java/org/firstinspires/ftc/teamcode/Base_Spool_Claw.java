package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Base_Spool_Claw", group="boundless")

public class Base_Spool_Claw extends LinearOpMode{

    //initiating motors
    private DcMotor spool = null;
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor leftRight = null;
    private Servo claw = null;
    private double clawPosition = 0.5;

    public void runOpMode(){

        // This connects the software to the hardware
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight  = hardwareMap.get(DcMotor.class, "frontRight");
        spool  = hardwareMap.get(DcMotor.class, "spool");
        claw  = hardwareMap.get(Servo.class, "claw");
        leftRight = hardwareMap.get(DcMotor.class, "leftRight");


        // This always updates telemetry
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        // This is sets the original joystick power
        double spoolLeftStick=0;
        double fbLeftStick=0;
        double fbRightStick=0;
        double leftRightReqPower=0;
        frontRight.setDirection(DcMotor.Direction.REVERSE);

        while(opModeIsActive()){

            // This will set the the motors to different parts of the controller.
            leftRightReqPower=this.gamepad2.right_stick_x;
            spoolLeftStick = -this.gamepad2.left_stick_y;
            fbLeftStick = -this.gamepad1.left_stick_y;
            fbRightStick = -this.gamepad1.right_stick_y;

            // Using methods created, the spool and the z-movement claw part will be 'activated'
            setPowerToSpool(spoolLeftStick);
            setPowerToLeftRight(leftRightReqPower);

            // We first need to stop the claw servo from moving if it is moving
            claw.setPosition(0.5);

            // Using other methods, we also 'activate' the actual claw mechanism
            stopClaw();
            openClaw();
            closeClaw();

            // Finally the tank is also 'activated'
            tank(fbLeftStick, fbRightStick);

            // Code below helps for debugging
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

    public void setPowerToSpool(double Stick){
        spool.setPower(Stick);
        telemetry.addData("Target Power", Stick);

    }

    public void openClaw() {
        if (gamepad2.y) {
            clawPosition = 0.9;
        }
        claw.setPosition(clawPosition);
        telemetry.addData("Claw Power", clawPosition);
    }

    public void closeClaw() {
        if (gamepad2.a) {
            clawPosition = 0.1;
        }
        claw.setPosition(clawPosition);
        telemetry.addData("Claw Power", clawPosition);
    }

    public void stopClaw() {
        if(gamepad2.b) {
            clawPosition = 0.5;
        }
        claw.setPosition(clawPosition);
        telemetry.addData("Claw Power", clawPosition);
    }


    public void setPowerToLeftRight(double power) {
        leftRight.setPower(-power);
        telemetry.addData("Target Power", power);
    }

}