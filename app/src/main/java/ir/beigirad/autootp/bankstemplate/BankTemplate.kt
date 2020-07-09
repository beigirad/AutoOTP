package ir.beigirad.autootp.bankstemplate

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
abstract class BankTemplate {
    abstract val keywords: Set<String>
    abstract val otpPatterns: Set<String>

    fun getCode(message: String): String? {
        keywords.forEach { bankKeyword ->
            val found = Regex(bankKeyword).containsMatchIn(message)
            if (found) {
                otpPatterns.forEach { otpPattern ->
                    Regex(otpPattern).find(message)?.also {
                        return it.groupValues.getOrNull(1)
                    }
                }
            }
        }
        return null
    }
}