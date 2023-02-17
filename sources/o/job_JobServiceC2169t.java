package o;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.service.job.NetflixJob;
import com.netflix.mediaclient.service.job.ServiceManagerHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
@TargetApi(21)
/* renamed from: o.t  reason: case insensitive filesystem */
public class job.JobServiceC2169t extends JobService implements ServiceManagerHelper.AbstractC0016 {

    /* renamed from: ˊ  reason: contains not printable characters */
    private ServiceManagerHelper f10301;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Handler f10302 = new Handler();

    /* renamed from: ˎ  reason: contains not printable characters */
    private final List<NetflixJob.NetflixJobId> f10303 = new ArrayList();

    /* renamed from: ˏ  reason: contains not printable characters */
    private final BroadcastReceiver f10304 = new BroadcastReceiver() { // from class: o.t.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            job.JobServiceC2169t.this.m10868(intent);
        }
    };

    /* renamed from: ॱ  reason: contains not printable characters */
    private final Map<NetflixJob.NetflixJobId, JobParameters> f10305 = new HashMap();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m10865();
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f10304, new IntentFilter("com.netflix.mediaclient.service.job.netflixjobservice.jobcomplete"));
    }

    @Override // android.app.Service
    public void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f10304);
        m10864();
        super.onDestroy();
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private void m10865() {
        if (this.f10301 == null) {
            this.f10301 = new ServiceManagerHelper(getApplicationContext(), this);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private void m10864() {
        if (this.f10301 != null) {
            this.f10301.m590();
            this.f10301 = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        NetflixJob.NetflixJobId r2 = NetflixJob.NetflixJobId.m581(jobParameters.getJobId());
        m10865();
        if (this.f10301.m588()) {
            this.f10303.clear();
            m10863();
            m10864();
            return false;
        }
        this.f10305.put(r2, jobParameters);
        if (!this.f10303.contains(r2)) {
            this.f10303.add(r2);
        }
        if (this.f10301.m586()) {
            this.f10302.post(new Runnable() { // from class: o.t.3
                @Override // java.lang.Runnable
                public void run() {
                    job.JobServiceC2169t.this.m10872();
                }
            });
            return true;
        }
        C1283.m16862("nf_job_service_l", "waiting for serviceManager to be ready");
        return true;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ॱ  reason: contains not printable characters */
    private void m10872() {
        if (this.f10301 != null) {
            Iterator<NetflixJob.NetflixJobId> it = this.f10303.iterator();
            while (it.hasNext()) {
                this.f10301.m589(it.next());
                it.remove();
            }
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    private void m10863() {
        Iterator<Map.Entry<NetflixJob.NetflixJobId, JobParameters>> it = this.f10305.entrySet().iterator();
        while (it.hasNext()) {
            C1283.m16862("nf_job_service_l", "markAllPendingJobsFinished calling jobFinish");
            it.remove();
            m10870(it.next().getValue());
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        NetflixJob.NetflixJobId r1 = NetflixJob.NetflixJobId.m581(jobParameters.getJobId());
        this.f10305.remove(r1);
        if (this.f10301 == null) {
            return false;
        }
        this.f10301.m587(r1);
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private void m10868(Intent intent) {
        NetflixJob.NetflixJobId r3 = NetflixJob.NetflixJobId.m581(intent.getIntExtra("NetflixJobId=", NetflixJob.NetflixJobId.UNKNOWN_JOB_ID.m582()));
        JobParameters jobParameters = this.f10305.get(r3);
        if (jobParameters != null) {
            this.f10305.remove(r3);
            m10870(jobParameters);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private void m10870(JobParameters jobParameters) {
        if (m10871(getApplicationContext())) {
            C1283.m16862("nf_job_service_l", "not calling Android JobService jobFinish");
            return;
        }
        C1283.m16862("nf_job_service_l", "calling Android JobService jobFinish");
        jobFinished(jobParameters, false);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m10867(Context context, NetflixJob.NetflixJobId netflixJobId, boolean z) {
        Intent intent = new Intent("com.netflix.mediaclient.service.job.netflixjobservice.jobcomplete");
        intent.putExtra("NetflixJobId=", netflixJobId.m582());
        intent.putExtra("needsReschedule", z);
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }

    @Override // com.netflix.mediaclient.service.job.ServiceManagerHelper.AbstractC0016
    /* renamed from: ˏ */
    public void mo592() {
        m10872();
    }

    @Override // com.netflix.mediaclient.service.job.ServiceManagerHelper.AbstractC0016
    /* renamed from: ˎ */
    public void mo591() {
        if (this.f10301 != null) {
            m10863();
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static boolean m10871(Context context) {
        return context == null || C1233.m16587(context);
    }
}
