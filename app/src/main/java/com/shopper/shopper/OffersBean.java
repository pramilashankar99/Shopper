package com.shopper.shopper;

/**
 * Created by apple on 15/03/16.
 * <p>
 * //********LISTVIEW************
 */
public class OffersBean {

    private int discount_image;
    private String rest_name;
    private String condi_text;

    public OffersBean(int discount_image, String rest_name, String condi_text) {
        this.discount_image = discount_image;
        this.rest_name = rest_name;
        this.condi_text = condi_text;
    }

    public int getDiscount_image() {
        return discount_image;
    }

    public void setDiscount_image(int discount_image) {
        this.discount_image = discount_image;
    }

    public String getRest_name() {
        return rest_name;
    }

    public void setRest_name(String rest_name) {
        this.rest_name = rest_name;
    }

    public String getCondi_text() {
        return condi_text;
    }

    public void setCondi_text(String condi_text) {
        this.condi_text = condi_text;
    }
}
