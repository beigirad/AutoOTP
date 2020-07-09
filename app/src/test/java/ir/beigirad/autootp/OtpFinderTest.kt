package ir.beigirad.autootp

import ir.beigirad.autootp.bankstemplate.ParsianBank
import ir.beigirad.autootp.bankstemplate.SamanBank
import org.junit.Assert
import org.junit.Test

class OtpFinderTest {
    @Test
    fun saman_otp_detected() {
        val sms1 = "رمز دوم پويا\n Code = 756042\nبانک سامان\nاعتبار تا 11:14:46  1399/4/18"
        val sms2 = "رمز پوياي برداشت وجه\n Code = 9381\nبانک سامان\n1399/4/18 \n14:34:39"

        Assert.assertEquals("756042", SamanBank().getCode(sms1))
        Assert.assertEquals("9381", SamanBank().getCode(sms2))

        val otherSms =
            "بانك سامان\nواريز مبلغ  30,000,000ريال\nبه  299-100-1112233-1 \nمانده 6,263,200\n1399/4/18\n14:07"
        Assert.assertNull(SamanBank().getCode(otherSms))
    }

    @Test
    fun parsian_otp_detected() {
        val otpSms =
            "*پارسیان بانک ایرانیان*\n  \nرمز یکبار مصرف 57758 \nمهلت استفاده دو دقیقه است."
        Assert.assertEquals("57758", ParsianBank().getCode(otpSms))

        val otherSms =
            "*پارسیان بانک ایرانیان*\n برداشت از:12345678910\nمبلغ:  1,689,500 ریال \nزمان: 1399/04/14 01:13:24\nمانده: 4,715,348 ریال"
        Assert.assertNull(ParsianBank().getCode(otherSms))
    }
}