package ir.beigirad.autootp

import ir.beigirad.autootp.OtpCaseFactory.allCases
import ir.beigirad.autootp.OtpCaseFactory.melli1
import ir.beigirad.autootp.OtpCaseFactory.parsian1
import ir.beigirad.autootp.OtpCaseFactory.parsian2
import ir.beigirad.autootp.OtpCaseFactory.saman1
import ir.beigirad.autootp.OtpCaseFactory.saman2
import ir.beigirad.autootp.OtpCaseFactory.saman3
import ir.beigirad.autootp.bankstemplate.MelliBank
import ir.beigirad.autootp.bankstemplate.ParsianBank
import ir.beigirad.autootp.bankstemplate.SamanBank
import org.junit.Assert
import org.junit.Test

class OtpFinderTest {
    @Test
    fun saman_otp_detected() {
        Assert.assertEquals(saman1.expectedOtp, SamanBank().getCode(saman1.message))
        Assert.assertEquals(saman2.expectedOtp, SamanBank().getCode(saman2.message))
        Assert.assertEquals(saman3.expectedOtp, SamanBank().getCode(saman3.message))
    }

    @Test
    fun parsian_otp_detected() {
        Assert.assertEquals(parsian1.expectedOtp, ParsianBank().getCode(parsian1.message))
        Assert.assertEquals(parsian2.expectedOtp, ParsianBank().getCode(parsian2.message))
    }

    @Test
    fun melli_otp_detected() {
        Assert.assertEquals(melli1.expectedOtp, MelliBank().getCode(melli1.message))
    }

    @Test
    fun otp_finder_works_well() {
        allCases.forEach {
            Assert.assertEquals(it.expectedOtp, OtpFinder.find(it.message))
        }
    }
}