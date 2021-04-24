package top.smartsoftware.smarthr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author xjx
 * @Date 2021-04-18
 */
@Configuration
public class CloudMarketConfig {

    @Value("${cloudmarket.ocr.appCode}")
    private String OCR_APPCODE;

    @Value("${cloudmarket.ocr.appKey}")
    private String OCR_APPKEY;

    @Value("${cloudmarket.ocr.appSecret}")
    private String OCR_APPSECRET;

    @Value("${cloudmarket.ocr.idCardUrl}")
    private String OCR_IDCARDURL;

    @Value("${cloudmarket.ocr.bankCardUrl}")
    private String OCR_BANKCARDURL;

    public String getOCR_APPCODE() {
        return OCR_APPCODE;
    }

    public void setOCR_APPCODE(String OCR_APPCODE) {
        this.OCR_APPCODE = OCR_APPCODE;
    }

    public String getOCR_APPKEY() {
        return OCR_APPKEY;
    }

    public void setOCR_APPKEY(String OCR_APPKEY) {
        this.OCR_APPKEY = OCR_APPKEY;
    }

    public String getOCR_APPSECRET() {
        return OCR_APPSECRET;
    }

    public void setOCR_APPSECRET(String OCR_APPSECRET) {
        this.OCR_APPSECRET = OCR_APPSECRET;
    }

    public String getOCR_IDCARDURL() {
        return OCR_IDCARDURL;
    }

    public void setOCR_IDCARDURL(String OCR_IDCARDURL) {
        this.OCR_IDCARDURL = OCR_IDCARDURL;
    }

    public String getOCR_BANKCARDURL() {
        return OCR_BANKCARDURL;
    }

    public void setOCR_BANKCARDURL(String OCR_BANKCARDURL) {
        this.OCR_BANKCARDURL = OCR_BANKCARDURL;
    }
}
