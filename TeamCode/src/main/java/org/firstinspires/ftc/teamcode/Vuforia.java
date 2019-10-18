package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name = "Vuforia", group = "boundless")

public class Vuforia extends LinearOpMode {

    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() throws InterruptedException {

        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);

        parameters.vuforiaLicenseKey = "AcCNMSn/////AAABmZxtapcFzUrfuuBkjremX+cFamDfj14dNrskO/OerUlO+nD07sXXlI91OEZOE97gtnBnTtd6Z8bnBtXPfYIslrip9bvDCyM6ywwAXrbyt7u6IkpgfE3Jf3MAug818wFFPfJn/MSZvWyU7Jm3ALlyMXgycgbcgT+sGVVsoIpfgQh0QRc+MAkb2EHcPl4AOGr3cpHMviz3b9k9JF6vzE8G23kxxYoGFrBpXFfBBilK6x6XDh+rfr5t+caCuM0k1wkpeR10tSSzfTx8fUpQllECZDjKQDOxGquiSYi/Kz/rdheBAdIy5o9gu071JPF0HFxeIMQb6c1NcregbiAfUueFoyD/yty+CZnE9sd0IVR3Cf0s";

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforia = ClassFactory.getInstance().createVuforia(parameters);

        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate"); // can help in debugging; otherwise not necessary

        telemetry.addData(">", "Press Play to start");
        telemetry.update();

        waitForStart();
    }
}
