package cn.com.smartdevices.bracelet.heartrate;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.gps.c.a.g;
import cn.com.smartdevices.bracelet.gps.services.O;
import cn.com.smartdevices.bracelet.ui.SystemBarTintActivity;
import com.amap.api.location.LocationManagerProxy;
import com.xiaomi.e.a;
import com.xiaomi.hm.health.R;
import kankan.wheel.widget.l;

public class HeartRateDetailsActivity extends SystemBarTintActivity implements OnClickListener {
    private static final String b = "HeartRateDetailsActivity";
    OnClickListener a = new f(this);
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private int g;
    private int h;
    private long i;
    private String j;
    private String k;
    private b l;
    private ImageView m;
    private LinearLayout n;

    private void a() {
        b();
        this.d = (TextView) findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.hr);
        this.f = (TextView) findViewById(R.id.hr_status);
        this.e = (TextView) findViewById(R.id.btn_sports);
        this.m = (ImageView) findViewById(R.id.hr_img);
        this.c.setText(this.h + a.f);
        this.l = b.a((Context) this);
        this.d.setText(getString(R.string.hr_me));
        this.n = (LinearLayout) findViewById(R.id.sports);
        c();
        if (this.g == 3) {
            this.f.setVisibility(8);
            this.n.setVisibility(0);
            return;
        }
        this.f.setVisibility(0);
        this.n.setVisibility(8);
        this.f.setText(this.k + a.f);
    }

    private String b() {
        String string;
        if (this.g == 0) {
            string = getString(R.string.hr_slow);
            this.k = getString(R.string.hr_detail_slow);
            return string;
        } else if (this.g == 1) {
            string = getString(R.string.hr_normal);
            this.k = getString(R.string.hr_detail_normal);
            return string;
        } else if (this.g == 2) {
            string = getString(R.string.hr_sports);
            this.k = a.f;
            return string;
        } else {
            string = getString(R.string.hr_fast);
            this.k = a.f;
            return string;
        }
    }

    private void c() {
        switch (this.g) {
            case kankan.wheel.widget.a.i /*0*/:
                this.m.setImageDrawable(getResources().getDrawable(R.drawable.heart_rate_slow));
                return;
            case l.a /*1*/:
                this.m.setImageDrawable(getResources().getDrawable(R.drawable.heart_rate_normal));
                return;
            case kankan.wheel.widget.a.k /*2*/:
                this.m.setImageDrawable(getResources().getDrawable(R.drawable.heart_rate_fast));
                return;
            case kankan.wheel.widget.a.l /*3*/:
                this.m.setImageDrawable(getResources().getDrawable(R.drawable.heart_rate_fast));
                return;
            default:
                return;
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                finish();
                return;
            default:
                return;
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_heart_details);
        try {
            this.g = Integer.parseInt(getIntent().getExtras().getString(LocationManagerProxy.KEY_STATUS_CHANGED));
            this.h = Integer.parseInt(getIntent().getExtras().getString(O.j));
            this.i = Long.parseLong(getIntent().getExtras().getString(g.f));
        } catch (NumberFormatException e) {
        }
        a();
    }
}
