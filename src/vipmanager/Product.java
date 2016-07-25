/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.io.Serializable;

/**
 *
 * @author liufangyang
 */
public class Product implements Serializable {

    private int productId;
    private String productName;
    private double price;
    private String description;
    private int quantityBeenSold;
    private String type;
    private static int idCount = 1;

    public int getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return this.price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantityBeenSold() {
        return this.quantityBeenSold;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityBeenSold(int quantity) {
        quantityBeenSold = quantityBeenSold + quantity;
    }

    public String toString() {
        return String.format("%-15d%-15s%-15.2f%-15s%-18s%-15d", this.getProductId(), this.productName, this.getPrice(), this.getDescription(),
                this.type, quantityBeenSold);
    }

    public String toStringVipVersion() {
        return String.format(("%-15s%-15.2f%-15s"), this.getProductName(), this.getPrice(), this.getDescription());
    }

    public Product(String productName, double price, String description, String type) {
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.type = type;
        this.productId = idCount;
        idCount++;
    }

}
