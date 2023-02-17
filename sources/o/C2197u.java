package o;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.netflix.mediaclient.service.job.NetflixJob;
import java.util.List;
@TargetApi(21)
/* renamed from: o.u  reason: case insensitive filesystem */
public class C2197u implements AbstractC2228v {

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Context f10675;

    public C2197u(Context context) {
        C1283.m16862("nf_job_scheduler", "NetflixJobSchedulerImpl");
        this.f10675 = context;
        if (C1233.m16588(context)) {
            C1283.m16862("nf_job_scheduler", "NetflixJobSchedulerImpl JobScheduler disabled.");
            m11317(this.f10675);
        }
    }

    @Override // o.AbstractC2228v
    /* renamed from: ˏ  reason: contains not printable characters */
    public boolean mo11321(NetflixJob.NetflixJobId netflixJobId) {
        if (!C1233.m16588(this.f10675)) {
            return m11318((JobScheduler) this.f10675.getSystemService("jobscheduler"), netflixJobId.m582()) != null;
        }
        C1283.m16862("nf_job_scheduler", "isJobScheduled no-op");
        return false;
    }

    @Override // o.AbstractC2228v
    /* renamed from: ˏ  reason: contains not printable characters */
    public void mo11320(NetflixJob netflixJob) {
        if (C1233.m16588(this.f10675)) {
            C1283.m16862("nf_job_scheduler", "scheduleJob no-op");
            return;
        }
        JobScheduler jobScheduler = (JobScheduler) this.f10675.getSystemService("jobscheduler");
        m11316(jobScheduler, netflixJob.m577().m582());
        JobInfo.Builder builder = new JobInfo.Builder(netflixJob.m577().m582(), new ComponentName(this.f10675.getPackageName(), job.JobServiceC2169t.class.getName()));
        if (netflixJob.m580()) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (netflixJob.m571()) {
            builder.setPeriodic(netflixJob.m579());
        } else if (netflixJob.m575() > 0) {
            builder.setMinimumLatency(netflixJob.m575());
        }
        builder.setRequiresCharging(netflixJob.m576());
        builder.setRequiresDeviceIdle(netflixJob.m573());
        jobScheduler.schedule(builder.build());
    }

    @Override // o.AbstractC2228v
    /* renamed from: ˊ  reason: contains not printable characters */
    public void mo11319(NetflixJob.NetflixJobId netflixJobId) {
        if (C1233.m16588(this.f10675)) {
            C1283.m16862("nf_job_scheduler", "cancelJob no-op");
        } else {
            m11316((JobScheduler) this.f10675.getSystemService("jobscheduler"), netflixJobId.m582());
        }
    }

    @Override // o.AbstractC2228v
    /* renamed from: ॱ  reason: contains not printable characters */
    public void mo11322(NetflixJob.NetflixJobId netflixJobId, boolean z) {
        if (C1233.m16587(this.f10675)) {
            C1283.m16862("nf_job_scheduler", "onJobFinished no-op");
        } else {
            job.JobServiceC2169t.m10867(this.f10675, netflixJobId, z);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static void m11316(JobScheduler jobScheduler, int i) {
        JobInfo r2 = m11318(jobScheduler, i);
        if (r2 != null) {
            C1283.m16862("nf_job_scheduler", "cancelJobIfExists cancelling..");
            jobScheduler.cancel(r2.getId());
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    private static JobInfo m11318(JobScheduler jobScheduler, int i) {
        List<JobInfo> allPendingJobs;
        if (jobScheduler == null || (allPendingJobs = jobScheduler.getAllPendingJobs()) == null) {
            return null;
        }
        for (JobInfo jobInfo : allPendingJobs) {
            if (jobInfo.getId() == i) {
                return jobInfo;
            }
        }
        return null;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m11317(Context context) {
        C1283.m16862("nf_job_scheduler", "cancelAllJobs");
        if (context != null) {
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            for (NetflixJob.NetflixJobId netflixJobId : NetflixJob.NetflixJobId.values()) {
                m11316(jobScheduler, netflixJobId.m582());
            }
        }
    }
}
