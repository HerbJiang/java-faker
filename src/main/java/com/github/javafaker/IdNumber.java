package com.github.javafaker;

import com.github.javafaker.idnumbers.EnIdNumber;
import com.github.javafaker.idnumbers.SvSEIdNumber;
import com.github.javafaker.idnumbers.ZhTWIdNumber;

public class IdNumber {
    private final Faker faker;

    protected IdNumber(Faker faker) {
        this.faker = faker;
    }

    public String valid() {
        return faker.fakeValuesService().resolve("id_number.valid", this, faker);
    }

    public String invalid() {
        return faker.numerify(faker.fakeValuesService().resolve("id_number.invalid", this, faker));
    }

    public String ssnValid() {
        EnIdNumber enIdNumber = new EnIdNumber();
        return enIdNumber.getValidSsn(faker);
    }

    /**
     * Specified as #{IDNumber.valid_sv_se_ssn} in sv-SE.yml
     */
    public String validSvSeSsn() {
        SvSEIdNumber svSEIdNumber = new SvSEIdNumber();
        return svSEIdNumber.getValidSsn(faker);
    }

    /**
     * Specified as #{IDNumber.invalid_sv_se_ssn} in sv-SE.yml
     */
    public String invalidSvSeSsn() {
        SvSEIdNumber svSEIdNumber = new SvSEIdNumber();
        return svSEIdNumber.getInvalidSsn(faker);
    }

    /**
     * Specified as #{IDNumber.valid_zh_tw_ssn} in zh-TW.yml
     */
    public String validZhTwSsn() {
        ZhTWIdNumber twIdNumber = new ZhTWIdNumber();
        return twIdNumber.getValidSsn(faker);
    }

    /**
     * Specified as #{IDNumber.invalid_zh_tw_ssn} in zh-TW.yml
     */
    public String invalidZhTwSsn() {
        ZhTWIdNumber twIdNumber = new ZhTWIdNumber();
        return twIdNumber.getInvalidSsn(faker);
    }
}
