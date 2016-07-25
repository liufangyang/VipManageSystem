/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author liufangyang
 */
public class Vip implements Serializable {

    private int vipId;
    private String firstName;
    private String lastName;
    private String gender;
    private Date dateOfBirth;
    private String emailAddress;
    private String phoneNumber;
    private String password;
    private int vipLevel;
    private double depositPoint;
    private double bonusPoint;
    private LocalDate createdDate = LocalDate.now();
    private static int idCount = 1;

    public Vip(String firstName, String lastName, String gender, Date dob, String email,
            String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dob;
        this.emailAddress = email;
        this.phoneNumber = phone;
        this.password = password;
        this.vipId = idCount;
        this.idCount++;
    }

    public int getId() {
        return this.vipId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public static double getDiscountRateByLevel(int vipLevel) {
        double discountRate = vipLevel / 1000;
        return discountRate;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.getFirstName() + this.getLastName();
    }

    public String getGender() {
        return this.gender;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getVipLevel() {
        return this.vipLevel;
    }

    public double getBonusPoint() {
        return this.bonusPoint;
    }

    public double getDepositPoint() {
        return this.depositPoint;
    }

    public String getPassword() {
        return this.password;
    }

    public LocalDate getCreatedDate() {
        return this.createdDate;
    }

    public void setId(int id) {
        this.vipId = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Date dob) {
        this.dateOfBirth = dob;
    }

    public void setEmailAddress(String email) {
        this.emailAddress = email;
    }

    public void setPhoneNumber(String phone) {
        this.phoneNumber = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public void setDepositPoint(double point) {
        this.depositPoint = point;
    }

    public void setBonusPoint(double point) {
        this.bonusPoint += point;
        int level = (int) bonusPoint / 50;
        this.setVipLevel(level);

    }

    public boolean isPasswordCorrect(String password) {
        if (this.password.equals(password)) {
            return true;
        }
        return false;
    }

    public boolean equals(Vip vip) {
        if (vip.getId() == this.vipId) {
            return true;
        }
        return false;
    }

    public boolean isTodayBirthday(Date date) {
        String sDate = DateFormaterUtil.DateToString(date);
        String dob = DateFormaterUtil.DateToString(this.dateOfBirth);
        String[] sDateArray = sDate.split("-");
        String[] dobArray = dob.split("-");
        if (sDateArray[1].equals(dobArray[1]) && sDateArray[2].equals(dobArray[2])) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%-10d%-20s%-15s%-23s%-20s%-20s%-15d%-20.2f%-18.2f%-20s",
                this.getId(), this.getFullName(), this.gender, DateFormaterUtil.DateToString(this.dateOfBirth), this.emailAddress, this.phoneNumber, this.vipLevel, this.bonusPoint, this.depositPoint, this.createdDate.toString());
    }

    public boolean equals(Object vip) {
        if (vip instanceof Vip) {
            Vip v = (Vip) vip;
            if (v.getId() == this.vipId) {
                return true;
            }
        }
        return false;

    }

}
