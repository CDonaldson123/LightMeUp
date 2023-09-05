package au.edu.swin.sdmd.lightmeup

import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.appcompat.content.res.AppCompatResources


class MainActivity : ComponentActivity() {

    private var state = R.drawable.mood_bad_black_24dp

    override fun onStop() {
        super.onStop()
        Log.i("Lifecycle", "stopped")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageview1)

        savedInstanceState?.let {
            state = it.getInt("IMAGE")
            imageView.setImageDrawable(getDrawable(state))
        }

        imageView.setOnClickListener {

            state = when (state) {
                R.drawable.mood_bad_black_24dp -> R.drawable.mood_black_24dp
                R.drawable.mood_black_24dp -> R.drawable.mood_bad_black_24dp
                else -> R.drawable.mood_bad_black_24dp
            }
            //show on screen
            imageView.setImageDrawable(AppCompatResources.getDrawable(this, state))
        }
        }
        override fun onSaveInstanceState(outState: Bundle) {
            super.onSaveInstanceState(outState)
            outState.putInt("IMAGE", state)
    }
}







