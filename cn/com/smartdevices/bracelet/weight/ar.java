package cn.com.smartdevices.bracelet.weight;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huami.android.view.c;
import com.xiaomi.hm.health.R;

public class ar extends c {
    protected int inflateLayout() {
        return R.layout.dialog_weight_info_modify_delete_confirm;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || arguments.getString("Msg") == null)) {
            ((TextView) onCreateView.findViewById(R.id.msg)).setText(arguments.getString("Msg"));
        }
        return onCreateView;
    }
}
