package ir.beigirad.autootp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast

/**
 * Created by Farhad Beigirad on 7/17/20.
 */
object ClipboardHelper {
    fun copyToClipboard(context: Context, message: String) {
        val clipboardManager =
            context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("otp", message)
        clipboardManager.setPrimaryClip(clipData)
        showToast(context)
    }

    private fun showToast(context: Context) {
        Toast.makeText(context, R.string.otp_copied, Toast.LENGTH_LONG).show()
    }
}