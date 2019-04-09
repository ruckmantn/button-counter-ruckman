package com.example.button_counter_ruckman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static int count;
    private TextView counter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button increase = this.findViewById(R.id.increase);
        Button decrease = this.findViewById(R.id.decrease);
        Button reset = this.findViewById(R.id.reset);
        counter = this.findViewById(R.id.counter);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            count = data.getInt("com.example.buttoncounterruckman.count");
        } else {
            count = 0;
        }

        counter.setText(String.format(Locale.US, "%d", count));

        //Increase 1
        Increase.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter.setText(String.format(Locale.US, "%d", ++count));
            }
        });

        //Increase 10
        increase.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                counter.setText(String.format(Locale.US, "%d", count += 10));
                return true;
            }
        });


        //decrease 1
        decrease.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                counter.setText(String.format(Locale.US, "%d", --count));
            }
        });

        //decrease 10
        decrease.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                counter.setText(String.format(Locale.US, "%d", count -= 10));
                return true;
            }
        });


        //Reset
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                count = 0;
                counter.setText(String.format(Locale.US, "%d", count));
            }
        });
    }

    protected void onDestroy() {

        super.onDestroy();

        Intent passData = new Intent(this, MainActivity.class);
        passData.putExtra("com.example.button-counter-ruckman", count);
        startActivity(passData);
    }
}
