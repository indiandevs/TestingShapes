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
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener,TimePickerDialog.OnTimeSetListener {

    PriceDailogData data;
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

        ConnectionDetector connectionDetector = new ConnectionDetector(this);
        ErrorDialogMessage errorDialogMessage = new ErrorDialogMessage(this);

        if (!connectionDetector.isConnectingToInternet()) {


            errorDialogMessage.show();
        }

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
        data = new PriceDailogData();
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


        Calendar[] dates = new Calendar[10];
        for(int i = 0; i <= 9; i++) {
            Calendar date = Calendar.getInstance();
            date.add(Calendar.DAY_OF_MONTH, i);
            dates[i] = date;
        }
        dpd.setSelectableDays(dates);

        dpd.setAccentColor(getResources().getColor(R.color.lighBlack));
        dpd.setCancelable(false);
        dpd.setTitle("SELECT PICKUP DATE");

        dpd.setOnDateSetListener(this);


        dpd.show(getFragmentManager(), "Calendar");


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


                data.icon = R.drawable.bus;
                data.type = "Bus";
                data.vechileName = "VOLVO,Kolvo";
                data.prices = "5000 6000 7000";
                data.context = MainActivity.this;

                PriceDailog priceDailog = PriceDailog.newInstance(data);
                priceDailog.show(fragmentManager, "Price");

            } else {
                selected = "bus";
            }

        } else if (id == R.id.iv_mini) {


            tvMini.setTextColor(getResources().getColor(R.color.colorAccent));
            if (selected.equals("mini")) {

                data.icon = R.drawable.mini;
                data.type = "Mini";
                data.vechileName = "Kulachi,Pulachi";
                data.prices = "1000 2000 3000";
                data.context = MainActivity.this;


                PriceDailog priceDailog = PriceDailog.newInstance(data);
                priceDailog.show(fragmentManager, "Price");
            } else {
                selected = "mini";
            }


        } else if (id == R.id.iv_prime) {


            tvPrime.setTextColor(getResources().getColor(R.color.colorAccent));

            if (selected.equals("prime")) {

                data.icon = R.drawable.prime;
                data.type = "Prime";
                data.vechileName = "Heman,Zeeman";
                data.prices = "2000 3000 4000";
                data.context = MainActivity.this;


                PriceDailog priceDailog = PriceDailog.newInstance(data);
                priceDailog.show(fragmentManager, "Price");
            } else {
                selected = "prime";
            }


        } else if (id == R.id.iv_sedan) {


            tvSedan.setTextColor(getResources().getColor(R.color.colorAccent));

            if (selected.equals("sedan")) {

                data.icon = R.drawable.sedan;
                data.type = "Sedan";
                data.vechileName = "Hitman";
                data.prices = "3000 4000 5000";
                data.context = MainActivity.this;


                PriceDailog priceDailog = PriceDailog.newInstance(data);
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

        selectTime();

    }

    private void selectTime() {

        Calendar now = Calendar.getInstance();
        TimePickerDialog tpd = TimePickerDialog.newInstance(
                MainActivity.this,
                now.get(Calendar.HOUR_OF_DAY),
                now.get(Calendar.MINUTE),
                true
        );
        tpd.setAccentColor(getResources().getColor(R.color.lighBlack));
        tpd.setTitle("Select PickUp Time");
        tpd.setCancelable(false);
        tpd.show(getFragmentManager(), "Time");

    }

    @Override
    public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute, int second) {


        Toast.makeText(MainActivity.this,"WE WILL CALL YOU",Toast.LENGTH_SHORT).show();


    }
}
