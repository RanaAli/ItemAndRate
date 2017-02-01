package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

@Parcel
public class Item {

    @SerializedName("amount")
    @Expose
    protected String amount;

    protected String amountGBP;

    @SerializedName("sku")
    @Expose
    protected String sku;

    @SerializedName("currency")
    @Expose
    protected String currency;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAmountGBP() {
        return amountGBP;
    }

    public void setAmountGBP(String amountGBP) {
        this.amountGBP = amountGBP;
    }
}