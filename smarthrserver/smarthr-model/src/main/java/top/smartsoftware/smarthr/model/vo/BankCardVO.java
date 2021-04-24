package top.smartsoftware.smarthr.model.vo;

/**
 * @Description
 * @Author xjx
 * @Date 2021-04-20
 */
public class BankCardVO {
    private String bankName;
    private String cardNum;
    private String cardType;
    private String validDate;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getValidDate() {
        return validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }
}
