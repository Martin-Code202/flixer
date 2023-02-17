package o;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.google.android.gms.location.ActivityRecognitionResult;
import java.util.ArrayList;
public class BH extends IntentService {
    public BH() {
        super("ActivityRecognizedService");
    }

    /* access modifiers changed from: protected */
    @Override // android.app.IntentService
    public void onHandleIntent(Intent intent) {
        if (ActivityRecognitionResult.hasResult(intent)) {
            ActivityRecognitionResult extractResult = ActivityRecognitionResult.extractResult(intent);
            Intent intent2 = new Intent("com.netflix.mediaclient.ACTIVITIES_BROADCAST_ACTION");
            intent2.putExtra("com.netflix.mediaclient.ACTIVITIES_EXTRA", (ArrayList) extractResult.getProbableActivities());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
        }
    }
}
