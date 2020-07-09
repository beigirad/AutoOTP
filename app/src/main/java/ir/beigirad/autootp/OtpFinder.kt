package ir.beigirad.autootp

import ir.beigirad.autootp.bankstemplate.SamanBank

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
object OtpFinder {
    val banks = listOf(
        SamanBank()
    )

    fun find(text: String): String? {
        banks.forEach {
            it.getCode(text)?.run {
                return this
            }
        }
        return null
    }
}