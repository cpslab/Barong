package jp.ac.dendai.im.cps.spawn.barong

import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class AccelerometerSensor : SensorEventListener {
    lateinit var mSensorManager: SensorManager
    var mAccelerometer : Sensor? = null
    var values = null

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event != null) {
            values = event.values as Nothing?
        }
    }


}