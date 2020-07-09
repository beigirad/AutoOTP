package ir.beigirad.autootp.bankstemplate

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
class ParsianBank : BankTemplate() {
    override val keywords: Set<String>
        get() = setOf("پارسیان بانک ایرانیان")
    override val otpPatterns: Set<String>
        get() = setOf("رمز یکبار مصرف (\\d+)")
}