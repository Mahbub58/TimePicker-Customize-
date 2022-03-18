package com.silentsecurity.customtiimepiker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements timepicker.timepickerListener {

    TextView tv2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);
        tv2=findViewById(R.id.tv2);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
    public void openDialog(){

        timepicker Timepicker=new timepicker();
        Timepicker.show(getSupportFragmentManager(),"timepicker");

    }

    @Override
    public void aplyText(String timeOn, String timeTo) {
        tv.setText(timeOn);
        tv2.setText(timeTo);
    }
}
