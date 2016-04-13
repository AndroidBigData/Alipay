package shangbeibei.com.alipays.utils.common;

/**
 * Created by Administrator on 2016/2/20.
 */
public class Constants {

    public static final int SDK_PAY_FLAG = 1;

    public static final int SDK_CHECK_FLAG = 2;


    // 商户PID2088911708698726//2088221293259317
    public static final String PARTNER = "2088911708698726";
    // 商户收款账号211275767@qq.com//3305472933@qq.com
    public static final String SELLER = "211275767@qq.com";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALL5UUqH6uYIDjK5CFohhNhdW/M9L0bYruS6Fy88MhK2IC9P/E/9P0d/d5DDt+EzK1P2dYC6PCBBWjeN/wxA2bcIx5DmEwYvWwGx4/f5bvwdbaMg26/IDVbp+pdDuyGhCm5+EGdGapucTzAkGybDLwKYQZISVKKFRips24+YdhI7AgMBAAECgYAe+UL2URt4AADlClzFrHNfNpkJOZeK/UkXUJVemV5ZGqfrSD50YXGoIAlDRnv2P3LKLycaxiBNvMGuR6bSKg8DcgAmqBUrAzVO7/uNuE6xtv/WHC/nSyLHsJrj8M0ARUzItebx2HMXgZiQFl41XuQ/v0eZ6oIk+Y7MQojNbOwRkQJBAOU73EGQFlKz0vaVpdjmSjKMIVs9fLG3lVvG1epBZBi9xBdTJu2D62u2aboVkCc5ZFjfvEZLftKu3ytF3pEXV78CQQDH3xz13HlPiDY9wU3XfCUgbesh+mQiEfq4FK9vZK4WStCH4ZiomcRxa0d0N5yLCjA/TnzGTSKH2MEAYDL/qYSFAkB2u2edCd2WHpAhqmdJjhZWUiCg2pswja8t5zI7cH1BF2Fu12HtWgvhMY1Xlf2hY2enZNNm8YmR5IOxLTJXomiPAkABVGao7BKSiOFzf7m42UaV9KU/0J6h62SznM+d+hl+ZHkGrmWJmZxI9OHA0C3mbubrROZnm1PDe5mtGva75LDRAkEAkjJDbwyHP2Vn1Nv6jyBnbV6KfrL5GpFGiio7lE0HQDKf6YRRCF4upCUU/vbwAPiI0vSJUrUVd7hu9MtUujWrCQ==";
//    public static final String RSA_PRIVATE ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK8UrcLDtLJuX6Zc\n" +
//            "kUoznDCq5QyGHABcr0tjoAfdVrI1AfMYPTjk67rBky5lUcffvceIB7yDeBXv7qF/\n" +
//            "V1MmbnqKEMPItfhl0XpynLgsbvl3FBqFsTwgLLFIj10w4FTnBrGJHNOvlSrm85+x\n" +
//            "C8WrSGXCY9BOCFCPg5A/X3KyYfHpAgMBAAECgYAIf3tzoaYqpvrTi1it/lVNc24M\n" +
//            "rpG7XsRPZ3WEDDVCDxqaHwoRseLTPMQVE2vlxLFkdvDRMJxqjCvMAO9PJOVlzqgL\n" +
//            "gHHI8pken0syDVrnjMlwfxFwikGnMbETXaMEIYZRilsqeSfP12clUbkePg8w7uaq\n" +
//            "errKDR2jD0kMFEk1NQJBAOF1ufQWaMpFQzdmIbiXv0V4TADNKVAVZuH7KQn7xbl+\n" +
//            "FxGvlMH5AVxG5mwJxUm/caXHJ53cPDG4PC3M/0pOh6sCQQDGy/TJVVQvI38QkxwA\n" +
//            "W8gueIjda/OcpmyoEPCS3QNYJpN9ukbenkFD74rsxNdSsTFtr3XLWiFpU+KZ5Jbe\n" +
//            "1oi7AkA6q0XubH5sVEW/fsY7oNFXJIyykLC1dDxHhfIR9QBo2pTqN0SAjWl7N7/y\n" +
//            "UUCThkvulbqLa6oGTijqyjOMhI7tAkAMmbzoTgpJ+pwBNvHda/PiTi2Oq1sDoODe\n" +
//            "PkShanTdz4Qlwfrf/XPxlGtf2pIzYZvacfarbwkTHggM7RpLAZolAkEA0ArUfY9q\n" +
//            "SWVHXGf9Z+54USYddMAAeIdxpsC3XkGYpsIBq7wfWyiy/CaA5ywHB1eD2qPUAGkr\n" +
//            "S8Q938RdraUoiQ==";
    // 支付宝公钥65537
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCvFK3Cw7Sybl+mXJFKM5wwquUMhhwAXK9LY6AH3VayNQHzGD045Ou6wZMuZVHH373HiAe8g3gV7+6hf1dTJm56ihDDyLX4ZdF6cpy4LG75dxQahbE8ICyxSI9dMOBU5waxiRzTr5Uq5vOfsQvFq0hlwmPQTghQj4OQP19ysmHx6QIDAQAB";
//    public static final String RSA_PUBLIC ="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDI6d306Q8fIfCOaTXyiUeJHkrIvYISRcc73s3vF1ZT7XN8RNPwJxo8pWaJMmvyTn9N4HQ632qJBVHf8sxHi/fEsraprwCtzvzQETrNRwVxLO5jVmRGi60j8Ue1efIlzPXV9je9mkjzOmdssymZkh2QhUrCmZYI/FCEa3/cNMW0QIDAQAB";
}
