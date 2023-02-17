package o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.android.activity.NetflixActivity;
public class qR extends AbstractC0496 implements SeekBar.OnSeekBarChangeListener {

    /* renamed from: ʽ  reason: contains not printable characters */
    private BroadcastReceiver f9540;

    /* renamed from: ˏ  reason: contains not printable characters */
    private SeekBar f9541;

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static qR m9948() {
        qR qRVar = new qR();
        qRVar.setStyle(1, 0);
        return qRVar;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.volume_bar_frag, viewGroup, false);
        this.f9541 = (SeekBar) inflate.findViewById(R.id.volume_seek_bar);
        this.f9541.setOnSeekBarChangeListener(this);
        this.f9541.setMax(100);
        return inflate;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        this.f9540 = new BroadcastReceiver() { // from class: o.qR.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                int intExtra = intent.getIntExtra("volume", -1);
                if (intExtra >= 0) {
                    qR.this.f9541.setProgress(intExtra);
                } else {
                    C1283.m16850("VolumeDialogFrag", "Volume value is missed from MDX_ACTION_SETVOLUME Intent");
                }
            }
        };
        LocalBroadcastManager.getInstance(getActivity()).registerReceiver(this.f9540, new IntentFilter("com.netflix.mediaclient.intent.action.MDX_ACTION_SETVOLUME"));
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: o.qR.5
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (qR.this.getActivity() != null) {
                    return ((NetflixActivity) qR.this.getActivity()).dispatchKeyEvent(keyEvent);
                }
                return false;
            }
        });
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (getActivity() != null && this.f9540 != null) {
            LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(this.f9540);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        this.f9541.setProgress(m9946());
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        int progress = seekBar.getProgress();
        C1283.m16846("VolumeDialogFrag", "Setting mdx volume to: " + progress);
        m14476().getCastPlayerFrag().mo11485(progress);
    }

    @Override // o.AbstractC0496, o.AbstractC0459
    public boolean isLoadingData() {
        return false;
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    private int m9946() {
        uU castPlayerFrag = m14476().getCastPlayerFrag();
        if (castPlayerFrag != null) {
            return castPlayerFrag.mo11482();
        }
        return 100;
    }
}
