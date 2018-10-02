package jp.ac.dendai.im.cps.spawn.barong

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : WearableActivity(), SensorEventListener {
    private lateinit var mSensorManager: SensorManager
    private var mAccelerometer : Sensor? = null

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        text.text = event?.values?.get(0).toString()
    }

    override fun onResume() {
        super.onResume()
        mAccelerometer?.also { accelerometer ->
            mSensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)        }
    }

    override fun onPause() {
        super.onPause()
        mSensorManager.unregisterListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        button.setOnClickListener{
            if (editText.text != null) {
                text.text = editText.text.toString()
            }
        }
    }
}
