package org.linphone.mediastream.video.capture.hwconf;

import android.hardware.Camera;
import java.util.ArrayList;
import java.util.List;
import org.linphone.mediastream.Log;
import org.linphone.mediastream.video.capture.hwconf.AndroidCameraConfiguration;
/* access modifiers changed from: package-private */
public class AndroidCameraConfigurationReader5 {
    AndroidCameraConfigurationReader5() {
    }

    public static AndroidCameraConfiguration.AndroidCamera[] probeCameras() {
        ArrayList arrayList = new ArrayList(1);
        Camera open = Camera.open();
        List<Camera.Size> supportedPreviewSizes = open.getParameters().getSupportedPreviewSizes();
        open.release();
        if (Hacks.isGalaxySOrTab()) {
            Log.d("Hack Galaxy S : has one or more cameras");
            if (Hacks.isGalaxySOrTabWithFrontCamera()) {
                Log.d("Hack Galaxy S : HAS a front camera with id=2");
                arrayList.add(new AndroidCameraConfiguration.AndroidCamera(2, true, 90, supportedPreviewSizes));
            } else {
                Log.d("Hack Galaxy S : NO front camera");
            }
            Log.d("Hack Galaxy S : HAS a rear camera with id=1");
            arrayList.add(new AndroidCameraConfiguration.AndroidCamera(1, false, 90, supportedPreviewSizes));
        } else {
            arrayList.add(new AndroidCameraConfiguration.AndroidCamera(0, false, 90, supportedPreviewSizes));
            if (Hacks.hasTwoCamerasRear0Front1()) {
                Log.d("Hack SPHD700 has 2 cameras a rear with id=0 and a front with id=1");
                arrayList.add(new AndroidCameraConfiguration.AndroidCamera(1, true, 90, supportedPreviewSizes));
            }
        }
        return (AndroidCameraConfiguration.AndroidCamera[]) arrayList.toArray(new AndroidCameraConfiguration.AndroidCamera[arrayList.size()]);
    }
}
