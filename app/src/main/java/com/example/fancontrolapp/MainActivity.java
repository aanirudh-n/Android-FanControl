package com.example.fancontrolapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvTemperature, tvFanSpeed;
    private SeekBar seekFanSpeed;
    private Button btnSwing, btnBoost, btnOn, btnOff, btnSetTimer;
    private int fanSpeed = 0;  // 0-5 range

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI Components
        tvTemperature = findViewById(R.id.tvTemperature);
        tvFanSpeed = findViewById(R.id.tvFanSpeed);
        seekFanSpeed = findViewById(R.id.seekFanSpeed);
        btnSwing = findViewById(R.id.btnSwing);
        btnBoost = findViewById(R.id.btnBoost);
        btnOn = findViewById(R.id.btnOn);
        btnOff = findViewById(R.id.btnOff);
        btnSetTimer = findViewById(R.id.btnSetTimer);

        // SeekBar Change Listener
        seekFanSpeed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                fanSpeed = progress;
                tvFanSpeed.setText("Fan Speed: " + fanSpeed);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        // Boost Fan Speed to Max
        btnBoost.setOnClickListener(v -> {
            seekFanSpeed.setProgress(5);
            fanSpeed = 5;
            tvFanSpeed.setText("Fan Speed: 5 (Boosted)");
        });

        // Swing Button
        btnSwing.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Swing Activated!", Toast.LENGTH_SHORT).show());

        // Turn On Button
        btnOn.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Fan Turned ON!", Toast.LENGTH_SHORT).show());

        // Turn Off Button
        btnOff.setOnClickListener(v -> {
            seekFanSpeed.setProgress(0);
            fanSpeed = 0;
            tvFanSpeed.setText("Fan Speed: 0");
            Toast.makeText(MainActivity.this, "Fan Turned OFF!", Toast.LENGTH_SHORT).show();
        });

        // Set Timer
        btnSetTimer.setOnClickListener(v -> Toast.makeText(MainActivity.this, "Timer Set!", Toast.LENGTH_SHORT).show());

        // Simulate Temperature Display (Mock Data)
        tvTemperature.setText("Temperature: 25°C"); // Replace with real sensor data if needed
    }
}
