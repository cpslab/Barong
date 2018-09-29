package jp.ac.dendai.im.cps.spawn.barong

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.support.wear.widget.WearableRecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        button.setOnClickListener{
            if (editText.text != null) {
                text.text = editText.text.toString()
            }
        }


    }
}
