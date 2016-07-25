/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

/**
 *
 * @author liufangyang
 */
public class FreeDrinkCoupon extends Coupon {

    private String productType;

    public FreeDrinkCoupon(String name, int day, String description, String productType) {
        super(name, day, description);
        this.productType = productType;

    }

    public String toString() {
        return super.toString() + String.format("%-25s", this.productType);

    }

    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
