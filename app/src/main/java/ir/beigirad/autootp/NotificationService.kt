package ir.beigirad.autootp

import android.app.IntentService
import android.content.Context
import android.content.Intent
import android.os.Handler
import timber.log.Timber

/**
 * Created by Farhad Beigirad on 7/17/20.
 */
class NotificationService : IntentService("NotificationService") {
    companion object {
        private const val ACTION_COPY_OTP = "ACTION_COPY_OTP"
        private const val EXTRA_OTP = "EXTRA_OTP"
        private const val EXTRA_NOTIFICATION_ID = "EXTRA_NOTIFICATION_ID"

        fun intentForCopyOtp(context: Context, otp: String, notificationId: Int) =
            Intent(context, NotificationService::class.java).apply {
                action = ACTION_COPY_OTP
                putExtra(EXTRA_OTP, otp)
                putExtra(EXTRA_NOTIFICATION_ID, notificationId)
            }
    }

    private lateinit var handler: Handler
    override fun onCreate() {
        super.onCreate()
        handler = Handler()
    }

    override fun onHandleIntent(intent: Intent?) {
        Timber.d("onHandleIntent $intent")
        when (intent?.action) {
            ACTION_COPY_OTP -> {
                handler.post {
                    val otp = intent.getStringExtra(EXTRA_OTP)
                    val notificationId = intent.getIntExtra(EXTRA_NOTIFICATION_ID, 0)
                    NotificationHelper(this).cancelNotification(notificationId)
                    ClipboardHelper.copyToClipboard(this, otp)
                }
            }
            else -> {
            }
        }
    }
}