package ir.beigirad.autootp

import android.app.Application
import timber.log.Timber

/**
 * Created by Farhad Beigirad on 7/8/20.
 */
class FishyApp : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree());
    }
}