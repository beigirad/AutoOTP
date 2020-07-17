package ir.beigirad.autootp

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import kotlin.random.Random

/**
 * Created by Farhad Beigirad on 7/17/20.
 */
class NotificationHelper(private val context: Context) {
    companion object {
        const val newOtpChannelId = "new_otp"
        const val testChannelId = "test_notification"
    }

    init {
        initNotificationChannel()
    }

    fun raiseNotification(otp: String) {
        val notificationId = Random.nextInt()
        val notification = NotificationCompat.Builder(context, newOtpChannelId)
            .setAutoCancel(true)
            .setContentText("Received Otp: $otp")
            .setSmallIcon(R.drawable.ic_otp)
            .addAction(
                0,
                "Copy $otp",
                PendingIntent.getService(
                    context,
                    -1,
                    NotificationService.intentForCopyOtp(context, otp, notificationId),
                    PendingIntent.FLAG_ONE_SHOT
                )
            ).build()

        getNotificationManager().notify(notificationId, notification)
    }

    fun raiseTestNotification() {
        val randomOtp = Random.nextInt(100_000, 900_000)
        val notification = NotificationCompat.Builder(context, testChannelId)
            .setSmallIcon(R.drawable.ic_otp)
            .setContentText(
                "محرمانه\nرمز برداشت وجه از کارت شما: $randomOtp\nاعتبار: 120 ثانيه"
            ).build()

        getNotificationManager().notify(1001, notification)
    }

    private fun getNotificationManager(): NotificationManager {
        return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    private fun initNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val eventChannel = NotificationChannel(
                newOtpChannelId,
                "New OTP",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val testChannel = NotificationChannel(
                testChannelId,
                "Test Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getNotificationManager()
            notificationManager.createNotificationChannel(eventChannel)
            notificationManager.createNotificationChannel(testChannel)
        }
    }

    fun cancelNotification(notificationId: Int) {
        getNotificationManager().cancel(notificationId)
    }
}