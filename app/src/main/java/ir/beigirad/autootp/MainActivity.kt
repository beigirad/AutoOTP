package ir.beigirad.autootp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

/**
 * Created by Farhad Beigirad on 7/8/20.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("onCreate ")
        setContentView(R.layout.activity_main)

        btn_open_setting.setOnClickListener {
            startActivity(Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"))
        }
    }

    override fun onResume() {
        super.onResume()
        updateListeningStatus(isListeningNotifications())
    }

    private fun isListeningNotifications(): Boolean {
        return NotificationManagerCompat.getEnabledListenerPackages(this)
            .contains(packageName)
    }

    private fun updateListeningStatus(isListening: Boolean) {
        tv_status.setText(
            if (isListening) R.string.status_ok
            else R.string.status_not_ok
        )
        val colorId =
            if (isListening) android.R.color.holo_green_light
            else android.R.color.holo_red_dark
        tv_status.setTextColor(ContextCompat.getColor(this, colorId))
    }
}