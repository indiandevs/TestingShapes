package testing.testingshapes;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by baymax on 2/2/16.
 */

public class PriceDailog extends DialogFragment {


    ImageView icon;
    TextView vName, vType, price;
    static Context context;

    public PriceDailog() {


    }

    public static PriceDailog newInstance(int icon, String vType, String vName, String price,Context c) {

        PriceDailog priceDailog = new PriceDailog();
        context = c;
        Bundle args = new Bundle();
        args.putInt("icon", icon);
        args.putString("vName", vName);
        args.putString("vType", vType);
        args.putString("price", price);
        priceDailog.setArguments(args);
        return priceDailog;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);


        return inflater.inflate(R.layout.pricedailog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        icon = (ImageView) view.findViewById(R.id.dialog_iv_icon);
        vName = (TextView) view.findViewById(R.id.dialog_tv_vname);
        vType = (TextView) view.findViewById(R.id.dialog_tv_vtype);
        price = (TextView) view.findViewById(R.id.dialog_tv_price);


        Bundle args = getArguments();
        icon.setImageResource(args.getInt("icon"));
        vName.setText(args.getString("vName"));
        vType.setText(args.getString("vType"));
        price.setText(args.getString("price"));

    }

    @Override
    public void onResume() {
        super.onResume();

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        display.getMetrics(metrics);

        getDialog().getWindow().setLayout((int) (metrics.widthPixels*0.9),LayoutParams.WRAP_CONTENT);



    }


}
