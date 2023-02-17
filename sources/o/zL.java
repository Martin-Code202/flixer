package o;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.netflix.mediaclient.R;
import com.netflix.mediaclient.util.ViewUtils;
public class zL extends Fragment {

    /* renamed from: ˊ  reason: contains not printable characters */
    private CL f12683;

    /* renamed from: ˏ  reason: contains not printable characters */
    private zU f12684;

    /* renamed from: ˎ  reason: contains not printable characters */
    public static zL m13496(CL cl) {
        zL zLVar = new zL();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_survey", cl);
        zLVar.setArguments(bundle);
        return zLVar;
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_survey, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.question_num);
        TextView textView2 = (TextView) inflate.findViewById(R.id.title);
        TextView textView3 = (TextView) inflate.findViewById(R.id.question);
        TextView textView4 = (TextView) inflate.findViewById(R.id.negative_option);
        TextView textView5 = (TextView) inflate.findViewById(R.id.positive_option);
        TextView textView6 = (TextView) inflate.findViewById(R.id.skip);
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.selection1);
        final ImageView imageView2 = (ImageView) inflate.findViewById(R.id.selection2);
        final ImageView imageView3 = (ImageView) inflate.findViewById(R.id.selection3);
        final ImageView imageView4 = (ImageView) inflate.findViewById(R.id.selection4);
        final ImageView imageView5 = (ImageView) inflate.findViewById(R.id.selection5);
        this.f12683 = (CL) getArguments().getParcelable("extra_survey");
        if (this.f12683 == null || this.f12683.m4211()) {
            getActivity().finish();
            return inflate;
        }
        CM r19 = this.f12683.m4210();
        textView.setText(r19.m4216());
        textView2.setText(r19.m4218());
        textView3.setText(r19.m4220());
        textView4.setText(r19.m4222());
        textView5.setText(r19.m4219());
        textView6.setText(r19.m4221());
        textView6.setOnClickListener(new View.OnClickListener() { // from class: o.zL.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (zL.this.f12684 != null) {
                    zL.this.f12684.mo13508();
                }
            }
        });
        ViewUtils.m3028(new View.OnTouchListener() { // from class: o.zL.4

            /* renamed from: ʻ  reason: contains not printable characters */
            private boolean f12686 = true;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int action = motionEvent.getAction();
                if (!this.f12686 && motionEvent.getAction() != 1) {
                    return true;
                }
                if (action == 0) {
                    zL.this.m13499(view, true);
                    return true;
                } else if (action == 2 && !zL.this.m13497(view, motionEvent)) {
                    this.f12686 = false;
                    zL.this.m13499(view, false);
                    return true;
                } else if (action != 1) {
                    return true;
                } else {
                    this.f12686 = true;
                    if (!zL.this.m13497(view, motionEvent)) {
                        return true;
                    }
                    ViewUtils.m3028((View.OnTouchListener) null, imageView, imageView2, imageView3, imageView4, imageView5);
                    zL.this.m13498(view);
                    return true;
                }
            }
        }, imageView, imageView2, imageView3, imageView4, imageView5);
        return inflate;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˎ  reason: contains not printable characters */
    private boolean m13497(View view, MotionEvent motionEvent) {
        return motionEvent.getX() <= ((float) view.getWidth()) && motionEvent.getY() <= ((float) view.getHeight()) && motionEvent.getX() >= 0.0f && motionEvent.getY() >= 0.0f;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13499(View view, boolean z) {
        float f = z ? 1.2f : 1.0f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, View.SCALE_X, f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, View.SCALE_Y, f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.setDuration(200L);
        animatorSet.start();
        TransitionDrawable transitionDrawable = (TransitionDrawable) view.getBackground();
        if (z) {
            transitionDrawable.startTransition(200);
        } else {
            transitionDrawable.reverseTransition(200);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* renamed from: ˏ  reason: contains not printable characters */
    private void m13498(View view) {
        int i = 0;
        switch (view.getId()) {
            case R.id.selection1 /* 2131428434 */:
                i = 1;
                break;
            case R.id.selection2 /* 2131428435 */:
                i = 2;
                break;
            case R.id.selection3 /* 2131428436 */:
                i = 3;
                break;
            case R.id.selection4 /* 2131428437 */:
                i = 4;
                break;
            case R.id.selection5 /* 2131428438 */:
                i = 5;
                break;
        }
        if (this.f12684 != null) {
            this.f12684.mo13507(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof zU) {
            this.f12684 = (zU) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must implement SurveyListener");
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f12684 = null;
    }
}
