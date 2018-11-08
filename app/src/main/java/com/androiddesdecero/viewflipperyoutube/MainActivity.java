package com.androiddesdecero.viewflipperyoutube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private Button btBack;
    private Button btNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpButton();
        setUpViewFlipper();
    }

    private void setUpButton(){
        btBack = findViewById(R.id.btBack);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.setInAnimation(getApplicationContext(), R.anim.view_flipper_slide_in_right);
                viewFlipper.setOutAnimation(getApplicationContext(), R.anim.view_flipper_slide_out_left);
                viewFlipper.showPrevious();
            }
        });
        btNext = findViewById(R.id.btNext);
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startFlipping();
                viewFlipper.setInAnimation(getApplicationContext(), android.R.anim.slide_in_left);
                viewFlipper.setOutAnimation(getApplicationContext(), android.R.anim.slide_out_right);
                viewFlipper.showNext();
                //Nos muestra el objeto en la posición (0) o (1) o (2)
                //viewFlipper.setDisplayedChild(0);
            }
        });
    }

    private void setUpViewFlipper(){
        viewFlipper = findViewById(R.id.viewFlipper);
        TextView textView = new TextView(this);
        textView.setText("...............");
        textView.setGravity(Gravity.CENTER);
        viewFlipper.addView(textView);
    }

    private void startFlipping(){
        viewFlipper.setDisplayedChild(1);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.startFlipping();
    }
}
