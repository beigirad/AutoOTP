package ir.beigirad.autootp

import android.app.Notification
import android.provider.Telephony
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import timber.log.Timber

/**
 * Created by Farhad Beigirad on 7/8/20.
 */
class NotificationListener : NotificationListenerService() {
    override fun onListenerConnected() {
        Timber.i("onListenerConnected ")
    }

    override fun onListenerDisconnected() {
        Timber.d("onListenerDisconnected ")
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        Timber.d("onNotificationPosted ")
        if (isFromMessagingApp(sbn)) {
            processSmsContent(sbn)
        }
    }

    private fun isFromMessagingApp(sbn: StatusBarNotification): Boolean {
        return sbn.packageName == Telephony.Sms.getDefaultSmsPackage(baseContext)
    }

    private fun processSmsContent(sbn: StatusBarNotification) {
        sbn.notification.extras
            .getString(Notification.EXTRA_TEXT)?.let { messageContent ->
                OtpFinder.find(messageContent)?.let { otp ->
                    ClipboardHelper.copyToClipboard(baseContext, otp)
                }
            }
    }
}