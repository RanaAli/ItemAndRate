package utils;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public enum Currencies {
    USD(Constants.CODE_USD), AUD(Constants.CODE_AUD), GBP(Constants.CODE_GBP),
    CAD(Constants.CODE_CAD);

    String code;

    Currencies(String code) {
        this.code = code;
    }

    public static Currencies getCurrency(String code) {
        if (code.equalsIgnoreCase(Constants.CODE_USD)) {
            return USD;
        } else if (code.equalsIgnoreCase(Constants.CODE_AUD)) {
            return AUD;
        } else if (code.equalsIgnoreCase(Constants.CODE_GBP)) {
            return GBP;
        } else if (code.equalsIgnoreCase(Constants.CODE_CAD)) {
            return CAD;
        }

        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private static class Constants {
        public static final String CODE_USD = "USD";
        public static final String CODE_AUD = "AUD";
        public static final String CODE_GBP = "GBP";
        public static final String CODE_CAD = "CAD";
    }
}
