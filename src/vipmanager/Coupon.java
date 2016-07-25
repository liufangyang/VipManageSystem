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
public class Coupon implements Serializable
{

    protected int couponId;
    protected String couponName;
    protected LocalDate expirationDate;
    protected String description;
    protected static int countId = 1;
    protected Vip vip;

    public Coupon(String couponName, int day, String description) {
        this.couponId = countId;
        this.couponName = couponName;
        this.description = description;
        this.expirationDate = LocalDate.now().plusDays(day);
        countId++;
    }

    public Coupon() {
    }

    public int getId() {
        return this.couponId;
    }

    public String getCouponName() {
        return this.couponName;
    }

    public LocalDate getExpirationDate() {
        return this.expirationDate;
    }

    public String getDescription() {
        return this.description;
    }

    public Vip getVip() {
        return this.vip;
    }

    public void setExpirationDate(LocalDate day) {
        this.expirationDate = day;
    }

    public void setCouponName(String name) {
        this.couponName = name;
    }

    public void setExpirationDay(int day) {
        this.expirationDate = LocalDate.now().plusDays(day);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setVip(Vip vip) {

        this.vip = vip;
    }

    public boolean assignCoupon(Vip vip) {
        if (this.vip == null) {
            this.vip = vip;
            return true;
        }
        return false;

    }

    public String toString() {
        if (this.vip != null) {
            return String.format("%-15d%-15s%-15s%-15s%-15d", this.getId(), this.getCouponName(),
                    this.getExpirationDate().toString(), this.getDescription(), this.vip.getId());
        }
        return String.format("%-15d%-15s%-15s%-15s%-15s", this.getId(), this.getCouponName(),
                this.getExpirationDate().toString(), this.getDescription(), "   ");
    }

}
