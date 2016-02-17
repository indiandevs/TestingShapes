package testing.testingshapes;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {

    int selectedColor;
    ImageView ivBus, ivSedan, ivPrime, ivMini;
    TextView tvBus,tvSedan,tvPrime,tvMini;
    Button book;
    String selected;
    PriceDailog priceDailog;
    FragmentManager fragmentManager;
    View.OnClickListener bookListner;
    android.app.FragmentManager fragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selected = "none";
        ivBus = (ImageView) findViewById(R.id.iv_bus);
        ivSedan = (ImageView) findViewById(R.id.iv_sedan);
        ivMini= (ImageView) findViewById(R.id.iv_mini);
        ivPrime = (ImageView) findViewById(R.id.iv_prime);
        fragmentManager = getSupportFragmentManager();
        fragManager = getFragmentManager();
        book = (Button) findViewById(R.id.btn_book_now);
        ivBus.setOnClickListener(this);
        ivSedan.setOnClickListener(this);
        ivPrime.setOnClickListener(this);
        ivMini.setOnClickListener(this);

        selectedColor = getResources().getColor(R.color.colorAccent);

        Log.d("TEAM", "inside OnCreate");


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!selected.equals("none"))
                bookTicket();

            }
        });

    }

    private void bookTicket() {


        Calendar now = Calendar.getInstance();
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                MainActivity.this,
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH)
        );



        dpd.setThemeDark(true);
        dpd.setCancelable(false);
        int day = now.get(Calendar.HOUR_OF_DAY);


        dpd.show(getFragmentManager(), "Journey Date");


    }

    @Override
    protected void onResume() {
        super.onResume();

        tvBus = (TextView) findViewById(R.id.tv_bus);
        tvMini = (TextView) findViewById(R.id.tv_mini);
        tvPrime = (TextView) findViewById(R.id.tv_prime);
        tvSedan = (TextView) findViewById(R.id.tv_sedan);
        clear();
    }


    public void onClick(View view) {

        int price;
        int id = view.getId();
        clear();
        ((ImageView) view).setColorFilter(selectedColor);

        if (id == R.id.iv_bus) {

            tvBus.setTextColor(getResources().getColor(R.color.colorAccent));
            if (selected.equals("bus")) {
                PriceDailog priceDailog = PriceDailog.newInstance(R.mipmap.ic_launcher, "BUS", "VOLVO,Kolvo", "5000", this);
                priceDailog.show(fragmentManager, "Price");
            } else {
                selected = "bus";
            }

        } else if (id == R.id.iv_mini) {


            tvMini.setTextColor(getResources().getColor(R.color.colorAccent));
            if (selected.equals("mini")) {
                PriceDailog priceDailog = PriceDailog.newInstance(R.mipmap.ic_launcher, "MINI", "Kulachi,Pulachi", "1000", this);
                priceDailog.show(fragmentManager, "Price");
            } else {
                selected = "mini";
            }


        } else if (id == R.id.iv_prime) {


            tvPrime.setTextColor(getResources().getColor(R.color.colorAccent));

            if (selected.equals("prime")) {
                PriceDailog priceDailog = PriceDailog.newInstance(R.mipmap.ic_launcher, "Prime", "Heman,zeeman", "2000", this);

                priceDailog.show(fragmentManager, "Price");
            } else {
                selected = "prime";
            }


        } else if (id == R.id.iv_sedan) {


            tvSedan.setTextColor(getResources().getColor(R.color.colorAccent));

            if (selected.equals("sedan")) {
                PriceDailog priceDailog = PriceDailog.newInstance(R.mipmap.ic_launcher, "Sedan", "highman,goman", "2500", this);
                priceDailog.show(fragmentManager, "Price");
            } else {

                selected = "sedan";
            }

        }

        book.setAlpha(1);
        book.setTextColor(getResources().getColor(R.color.textColor));

    }

    private void clear() {

        int textColor = getResources().getColor(R.color.lighBlack);
        ivMini.setColorFilter(Color.TRANSPARENT);
        ivSedan.setColorFilter(Color.TRANSPARENT);
        ivBus.setColorFilter(Color.TRANSPARENT);
        ivPrime.setColorFilter(Color.TRANSPARENT);
        tvMini.setTextColor(textColor);
        tvSedan.setTextColor(textColor);
        tvPrime.setTextColor(textColor);
        tvBus.setTextColor(textColor);

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {




    }
}
