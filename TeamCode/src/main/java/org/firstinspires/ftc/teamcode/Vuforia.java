package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name = "Vuforia")

public class Vuforia extends LinearOpMode {

    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters parameters;
    VuforiaTrackables visionTargets;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastKnownLocation;
    OpenGLMatrix phoneLocation;

    public static final String VUFORIA_KEY = "AcCNMSn/////AAABmZxtapcFzUrfuuBkjremX+cFamDfj14dNrskO/" +
                                             "OerUlO+nD07sXXlI91OEZOE97gtnBnTtd6Z8bnBtXPfYIslrip9bvD" +
                                             "CyM6ywwAXrbyt7u6IkpgfE3Jf3MAug818wFFPfJn/MSZvWyU7Jm3AL" +
                                             "lyMXgycgbcgT+sGVVsoIpfgQh0QRc+MAkb2EHcPl4AOGr3cpHMviz3" +
                                             "b9k9JF6vzE8G23kxxYoGFrBpXFfBBilK6x6XDh+rfr5t+caCuM0k1w" +
                                             "kpeR10tSSzfTx8fUpQllECZDjKQDOxGquiSYi/Kz/rdheBAdIy5o9g" +
                                             "u071JPF0HFxeIMQb6c1NcregbiAfUueFoyD/yty+CZnE9sd0IVR3Cf0s";

    public void runOpMode() throws InterruptedException {

        waitForStart();

        while(opModeIsActive()) {
            telemetry.update();
            idle();
        }
    }
}
