package org.linphone.mediastream.video.capture.hwconf;

import android.hardware.Camera;
import java.util.ArrayList;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;
/* access modifiers changed from: package-private */
public class AndroidCameraConfigurationReader9 {
    AndroidCameraConfigurationReader9() {
    }

    public static AndroidCameraConfiguration.AndroidCamera[] probeCameras() {
        ArrayList arrayList = new ArrayList(Camera.getNumberOfCameras());
        for (int i = 0; i < Camera.getNumberOfCameras(); i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            Camera open = Camera.open(i);
            arrayList.add(new AndroidCameraConfiguration.AndroidCamera(i, cameraInfo.facing == 1, cameraInfo.orientation, open.getParameters().getSupportedPreviewSizes()));
            open.release();
        }
        return (AndroidCameraConfiguration.AndroidCamera[]) arrayList.toArray(new AndroidCameraConfiguration.AndroidCamera[arrayList.size()]);
    }
}
