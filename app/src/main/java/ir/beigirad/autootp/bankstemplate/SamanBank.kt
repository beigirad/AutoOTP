package ir.beigirad.autootp.bankstemplate

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
class SamanBank : BankTemplate() {
    override val keywords: Set<String>
        get() = setOf("بانک سامان")
    override val otpPatterns: Set<String>
        get() = setOf("Code = (\\d+)")
}