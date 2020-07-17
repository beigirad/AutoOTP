package ir.beigirad.autootp

/**
 * Created by Farhad Beigirad on 7/9/20.
 */
object OtpCaseFactory {
    val saman1 = Case(
        "رمز دوم پويا\n Code = 756042\nبانک سامان\nاعتبار تا 11:14:46  1399/4/18",
        "756042"
    )

    val saman2 = Case(
        "رمز پوياي برداشت وجه\n Code = 9381\nبانک سامان\n1399/4/18 \n14:34:39",
        "9381"
    )

    val saman3 = Case(
        "بانك سامان\nواريز مبلغ  30,000,000ريال\nبه  299-100-1112233-1 \nمانده 6,263,200\n1399/4/18\n14:07",
        null
    )

    val parsian1 = Case(
        "*پارسیان بانک ایرانیان*\n  \nرمز یکبار مصرف 57758 \nمهلت استفاده دو دقیقه است.",
        "57758"
    )

    val parsian2 = Case(
        "*پارسیان بانک ایرانیان*\n برداشت از:12345678910\nمبلغ:  1,689,500 ریال \nزمان: 1399/04/14 01:13:24\nمانده: 4,715,348 ریال",
        null
    )

    val melli1 = Case(
        "بانک ملي\nمحرمانه\nکارت: 1245\nرمزدوم: 5611728\nاعتبارتا: 21:30:00",
        "5611728"
    )

    val ayande1 = Case(
        "بانک آینده\nرمز دوم یکبار مصرف:\n6376325\nاعتبارتا:15:29:00",
        "6376325"
    )

    val mellat1 = Case(
        "محرمانه\nرمز برداشت وجه از کارت شما: 5371134\nاعتبار: 120 ثانيه",
        "5371134"
    )
    val mellat2 = Case(
        "بانک ملت\nخريد با کارت\nبرداشت از حساب 5411111115\nمبلغ : 9,230,000ريال\nموجودي : 17,970,170 ريال\nمستند : 23736\n99/04/14 16:49",
        null
    )

    val allCases = setOf(
        saman1,
        saman2,
        saman3,
        parsian1,
        parsian2,
        melli1,
        ayande1,
        mellat1,
        mellat2
    )
}

data class Case(
    val message: String,
    val expectedOtp: String?
)