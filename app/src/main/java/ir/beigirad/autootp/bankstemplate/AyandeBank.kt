package ir.beigirad.autootp.bankstemplate

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
class AyandeBank : BankTemplate() {
    override val keywords: Set<String>
        get() = setOf("بانک آینده")
    private val prefix = "رمز دوم یکبار مصرف:"
    override val otpPatterns: Set<String>
        get() = setOf("$prefix[\\s|s]*(\\d+)")
}