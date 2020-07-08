package ir.beigirad.fishymind

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
interface OtpFinder {
    fun find(text: String): String?
}

object GlobalOtpFinder : OtpFinder {
    object SamanBankFinder : OtpFinder {
        private val formats = listOf(Regex("Code = (\\d+)"))
        override fun find(text: String): String? {
            formats.forEach { regex ->
                regex.find(text)?.also { return it.groupValues[1] }
            }
            return null
        }
    }

    private val banks = arrayOf(SamanBankFinder)
    override fun find(text: String): String? {
        banks.forEach { bank ->
            bank.find(text)?.also { return it }
        }
        return null
    }
}