package ir.beigirad.autootp

import android.content.Context

/**
 * Created by Farhad Beigirad on 7/17/20.
 */
object PreferencesHelper {

    fun isEnableAutoCopy(context: Context): Boolean {
        val prefsFileName = context.getString(R.string.pref_name)
        return context
            .getSharedPreferences(prefsFileName, Context.MODE_PRIVATE)
            .getBoolean(context.getString(R.string.pref_auto_copy), false)
    }

    fun isEnableRaiseNotification(context: Context): Boolean {
        val prefsFileName = context.getString(R.string.pref_name)
        return context
            .getSharedPreferences(prefsFileName, Context.MODE_PRIVATE)
            .getBoolean(context.getString(R.string.pref_raise_notification), false)
    }
}