package com.busybox.ikunboat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.busybox.ikunboat.databinding.ActivityMainBinding;

import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'ikunboat' library on application startup.
    static {
        System.loadLibrary("ikunboat");
    }

    private ActivityMainBinding binding;

    private Button pedalUp;
    private Button pedalDown;
    private Button pedalLeft;
    private Button pedalRight;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pedalUp = findViewById(R.id.pedalUp);
        pedalDown = findViewById(R.id.pedalDown);
        pedalRight = findViewById(R.id.pedalRight);
        pedalLeft = findViewById(R.id.pedalLeft);

        new ReportThread().start();

        pedalUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ReportThread.upFlags = 100;
                return false;
            }
        });
        pedalDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ReportThread.downFlags = 100;
                return false;
            }
        });
        pedalLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ReportThread.leftFlags = 100;
                return false;
            }
        });
        pedalRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ReportThread.rightFlags = 100;
                return false;
            }
        });



    }

    /**
     * A native method that is implemented by the 'ikunboat' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}