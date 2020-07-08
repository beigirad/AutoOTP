package ir.beigirad.fishymind

import org.junit.Assert
import org.junit.Test

class OtpFinderTest {
    @Test
    fun saman_otp_detected() {
        val sms1 = "رمز دوم پويا\n Code = 756042\nبانک سامان\nاعتبار تا 11:14:46  1399/4/18"
        val sms2 = "رمز پوياي برداشت وجه\n Code = 9381\nبانک سامان\n1399/4/18 \n14:34:39"

        Assert.assertEquals("756042", GlobalOtpFinder.find(sms1))
        Assert.assertEquals("9381", GlobalOtpFinder.find(sms2))
    }

    @Test
    fun non_otp_message_detected() {
        val sms1 = "رمز دوم پويا\n Code = \nبانک سامان\nاعتبار تا 11:14:46  1399/4/18"
        val sms2 = ""

        Assert.assertNull(GlobalOtpFinder.find(sms1))
        Assert.assertNull(GlobalOtpFinder.find(sms2))
    }
}