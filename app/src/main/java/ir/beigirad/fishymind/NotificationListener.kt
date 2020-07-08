package ir.beigirad.fishymind

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

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        Timber.d("onNotificationPosted ")
    }
}