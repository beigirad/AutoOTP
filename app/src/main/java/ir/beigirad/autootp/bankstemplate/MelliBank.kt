package ir.beigirad.autootp.bankstemplate

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
class MelliBank : BankTemplate() {
    override val keywords: Set<String>
        get() = setOf("بانک ملي")
    override val otpPatterns: Set<String>
        get() = setOf("رمزدوم: (\\d+)")
}