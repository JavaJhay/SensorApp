package com.example.e_jhay.myapplication3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sm;
    Sensor acc;
    TextView outputX, outputY, outputZ;

    //Test Message for GitHub
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sensorlayout);

        outputX = findViewById(R.id.textView1);
        outputY = findViewById(R.id.textView2);
        outputZ = findViewById(R.id.textView3);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), sm.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER));
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] values = event.values;
        outputX.setText("x: " + values[0]);
        outputY.setText("y: " + values[1]);
        outputZ.setText("z: " + values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
