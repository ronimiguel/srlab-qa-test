package br.com.southrocklab.resources.tdm;

import br.com.southrocklab.resources.utils.DateUtils;

public class InfoCard {
    DateUtils dateUtils = new DateUtils();
    InfoCustomer infoCustomer = new InfoCustomer();

    private String brand = "VISA";
    private String cvc = "111";
    private String cvcMaior = "1110";
    private int expMonth = 02;
    private int expMonthMaior = 32;
    private int expYear = dateUtils.yearWithDiffOfYear(0);
    private int expYearMenor = dateUtils.yearWithDiffOfYear(-1);
    private String holderName = infoCustomer.getName() + " " + infoCustomer.getLastName();
    private String cardNumber = "1111111111111112";
    private String cardNumberMenor = "111111111111111";

    public String getBrand() {
        return brand;
    }

    public String getCvc() {
        return cvc;
    }

    public String getCvcMaior() {
        return cvcMaior;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public int getExpMonthMaior() {
        return expMonthMaior;
    }

    public int getExpYear() {
        return expYear;
    }

    public int getExpYearMenor() {
        return expYearMenor;
    }

    public String getHolderName() {
        return holderName;
    }

    public String getCardNumberMenor() {
        return cardNumberMenor;
    }

    public String getCardNumber() {
        return cardNumber;
    }

}
