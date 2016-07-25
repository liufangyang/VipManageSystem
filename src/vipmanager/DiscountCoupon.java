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
public class DiscountCoupon extends Coupon {

    private double discountRate;

    public DiscountCoupon(String name, int day, String description, double discountRate) {
        super(name, day, description);
        this.discountRate = discountRate;
    }

    public String toString() {
        return super.toString() + String.format("%40.2f", this.discountRate);
    }

    public double getDiscountRate() {
        return this.discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

}
