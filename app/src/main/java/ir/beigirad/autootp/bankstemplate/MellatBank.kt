package ir.beigirad.autootp.bankstemplate

/**
 * Created by Farhad Beigirad on 7/17/20.
 */
class MellatBank : BankTemplate() {
    override val keywords: Set<String>
        get() = setOf("محرمانه", "رمز برداشت")
    private val prefix = "رمز برداشت وجه از کارت شما:"
    override val otpPatterns: Set<String>
        get() = setOf("$prefix[\\s|s]*(\\d+)")
}