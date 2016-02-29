package testing.testingshapes;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
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

import java.util.StringTokenizer;

/**
 * Created by baymax on 2/2/16.
 */

public class PriceDailog extends DialogFragment {


    String ruppeSign;
    ImageView icon;
    TextView vName, vType, price;
    static Context context;

    public PriceDailog() {


    }

    public static PriceDailog newInstance(PriceDailogData priceDailogData) {


        PriceDailog priceDailog = new PriceDailog();
        context = priceDailogData.context;
        Bundle args = new Bundle();
        args.putInt("icon", priceDailogData.icon);
        args.putString("vName", priceDailogData.vechileName);
        args.putString("vType", priceDailogData.type);
        args.putString("price", priceDailogData.prices);
        priceDailog.setArguments(args);
        return priceDailog;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ruppeSign = getResources().getString(R.string.Rs);
        return inflater.inflate(R.layout.pricedailog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        icon = (ImageView) view.findViewById(R.id.dialog_iv_icon);
        vName = (TextView) view.findViewById(R.id.dialog_tv_vname);
        vType = (TextView) view.findViewById(R.id.dialog_tv_vtype);
        price = (TextView) view.findViewById(R.id.dialog_tv_price);

        icon.setColorFilter(getResources().getColor(R.color.colorAccent));
        Bundle args = getArguments();
        icon.setImageResource(args.getInt("icon"));
        vName.setText(args.getString("vName"));
        vType.setText(args.getString("vType"));

        StringTokenizer st = new StringTokenizer(args.getString("price"));

        price.setText(ruppeSign + st.nextToken() + "    "  +  ruppeSign + st.nextToken() + "    " + ruppeSign + st.nextToken());

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
