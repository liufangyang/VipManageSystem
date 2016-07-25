/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author liufangyang
 */
public class TransactionRecord implements Serializable {

    private LocalDate date;
    private Vip vip;
    private Product product;
    private Coupon coupon;
    private double discountRate;
    private int quantity;
    private double depositPointUsed;
    private double bonusPointEarned;
    private int transactionRecordId;
    private double paidAmount;
    private static int idCount = 1;
    //this.transactionId = idCount;
    //   this.idCount++;

    public TransactionRecord(LocalDate date, Vip vip, Product product, Coupon coupon, int quantity, double depositPointUsed, double bonusPointEarned) {
        this.vip = vip;
        this.date = date;
        this.product = product;
        this.coupon = coupon;
        this.quantity = quantity;
        this.depositPointUsed = depositPointUsed;
        this.bonusPointEarned = bonusPointEarned;
        this.transactionRecordId = idCount;
        idCount++;
    }

    public int getTransactionRecordId() {
        return this.transactionRecordId;
    }

    public double getpaidAmount() {
        return this.paidAmount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Coupon getCoupon() {
        return this.coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public double getDiscounRate() {
        return this.discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public double getBonusPointEarned() {
        return this.bonusPointEarned;
    }

    public void setBonusPointEarned(double bonusPointEarned) {
        this.bonusPointEarned = bonusPointEarned;
    }

    public Vip getVip() {
        return this.vip;
    }

    public Product getProduct() {
        return this.product;
    }

    public String toString() {
        if (this.coupon == null) {
            return String.format("%-20s%-20s%-20d%-20.2f%-25s%-25.2f%-25.2f%-20.2f",
                    this.date.toString(), this.product.getProductName(), this.quantity,
                    this.discountRate, "", this.bonusPointEarned,
                    this.paidAmount, this.depositPointUsed);
        }
        return String.format("%-20s%-20s%-20d%-20.2f%-25s%-25.2f%-25.2f%-20.2f",
                this.date.toString(), this.product.getProductName(), this.quantity,
                this.discountRate, this.coupon.getCouponName(), this.bonusPointEarned,
                this.paidAmount, this.depositPointUsed);

    }
}
