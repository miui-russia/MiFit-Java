package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.weight.aA;
import com.xiaomi.hm.health.R;
import de.greenrobot.event.EventBus;
import java.util.Locale;
import kankan.wheel.widget.WheelView;
import kankan.wheel.widget.a;
import kankan.wheel.widget.a.f;

public class C0796eq extends Fragment implements OnClickListener {
    private static final String a = "SettingInComingCallTimeFragment";
    private PersonInfo b;
    private WheelView c;
    private int d = 18;
    private TextView e;

    private void a(int i) {
        if (i == 2) {
            this.e.setText(R.string.incoming_call_notify_closed);
            return;
        }
        this.e.setText(getString(R.string.incoming_call_notify_tips, new Object[]{Integer.valueOf(i)}));
    }

    protected int a() {
        return R.layout.fragment_setting_incomingcall;
    }

    protected void b() {
        boolean z;
        int f = this.c.f() + 2;
        if (this.c.f() == 0 && this.d == 18) {
            f = 2;
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.b.enableInComingCallTime();
            this.b.miliConfig.incallNotifyEnabled = true;
        } else {
            this.b.disableInComingCallTime();
            this.b.miliConfig.incallNotifyEnabled = false;
        }
        C0596r.d(a, "get enable = " + this.b.isInComingCallEnabled() + " , delay = " + f);
        this.b.setInComingCallTime(f);
        this.b.setNeedSyncServer(2);
        Keeper.keepPersonInfo(this.b);
        EventBus.getDefault().post(new EventSettingFragmentUpdate());
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.confirm:
                if (getActivity() != null) {
                    getActivity().finish();
                }
                b();
                return;
            case R.id.cancel:
                if (getActivity() != null) {
                    getActivity().finish();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.b = Keeper.readPersonInfo();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(a(), viewGroup, false);
        this.e = (TextView) inflate.findViewById(R.id.incoming_call_cur_value);
        this.c = (WheelView) inflate.findViewById(R.id.wheel);
        f c0763dl = new C0763dl(getActivity(), 2, 30, this.c, getResources().getColor(R.color.highlight), getResources().getColor(R.color.main_ui_content_color), a.bm, false, 46, (int) (aA.h * 0.8f), (int) (21.0f * 0.8f), (int) (0.8f * 21.0f), 1);
        c0763dl.a(C0763dl.c);
        c0763dl.a(this.d);
        c0763dl.e(R.string.second);
        this.c.a(5).e(R.drawable.wheel_custom_val_white_1).a(com.xiaomi.e.a.f, (float) aA.h).a(c0763dl);
        int inComingCallTime = this.b.getInComingCallTime();
        if (inComingCallTime < 2) {
            inComingCallTime = 2;
        }
        this.c.c(inComingCallTime - 2);
        a(inComingCallTime);
        this.c.a(new C0797er(this));
        inflate.findViewById(R.id.cancel).setOnClickListener(this);
        inflate.findViewById(R.id.confirm).setOnClickListener(this);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.incoming_call_help_img);
        TextView textView = (TextView) inflate.findViewById(R.id.incoming_call_info_2);
        if (!Locale.getDefault().toString().equals(Locale.SIMPLIFIED_CHINESE.toString())) {
            imageView.setImageResource(R.drawable.incoming_help_3);
            textView.setVisibility(4);
        } else if (TextUtils.isEmpty(Utils.f(getActivity()))) {
            imageView.setImageResource(R.drawable.incoming_help_2);
            textView.setText(R.string.incomingcall_info_3);
        } else {
            imageView.setImageResource(R.drawable.incoming_help_1);
            textView.setText(R.string.incomingcall_info_2);
        }
        return inflate;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
    }
}
