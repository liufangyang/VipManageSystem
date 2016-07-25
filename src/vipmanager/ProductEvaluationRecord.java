/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author liufangyang
 */
public class ProductEvaluationRecord implements Serializable {

    private Product product;
    private LinkedList<Vip> evaluatedVipList = new LinkedList<Vip>();
    private LinkedList<String> commentList = new LinkedList<String>();
    private LinkedList<Double> evaluationPointList = new LinkedList<Double>();
    private LinkedList<LocalDate> evaluateDateList = new LinkedList<LocalDate>();

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return this.product;
    }

    public void addToEvaluatedVipList(Vip vip) {
        this.evaluatedVipList.add(vip);
    }

    public void addToCommentList(String comment) {
        this.commentList.add(comment);
    }

    public void addToEvaluationPointList(double point) {
        this.evaluationPointList.add(point);
    }

    public void addToEvaluatedDateList(LocalDate date) {

        this.evaluateDateList.add(date);
    }

    public LinkedList<String> getCommentList() {
        return this.commentList;
    }

    public ProductEvaluationRecord() {

    }

    public ProductEvaluationRecord(Product product) {
        this.product = product;
    }

//    public String toString() {
//        String comment = "";
//
//        for (int i = 0; i < this.evaluatedVipList.size(); i++) {
//            comment += String.format("%-20s%-20s%-20.2f%s\n", this.evaluatedVipList.get(i).getFullName(), this.commentList.get(i), this.evaluationPointList.get(i), this.evaluateDateList.get(i).toString());
//
//        }
//        return String.format("%-17s%-80s", this.getProduct().getProductName(), comment);
//
//    }
    public String toString(int i) {
        String comment = "";
        if (i == 0) {
            return String.format("%-17s%-80s", this.getProduct().getProductName(), comment);
        }
        if (i > 0) {
            comment = String.format("%-20s%-20s%-20.2f%s\n", this.evaluatedVipList.get(i - 1).getFullName(), this.commentList.get(i - 1), this.evaluationPointList.get(i - 1), this.evaluateDateList.get(i - 1).toString());
            return String.format("%-17s%-80s", this.getProduct().getProductName(), comment);
        }
        return null;
    }

    public double getAverageEvaluationPoint(LinkedList<Double> evaluationPointList) {
        double sum = 0;

        for (int i = 0; i < evaluationPointList.size(); i++) {
            sum += evaluationPointList.get(i);
        }
        double average = sum / evaluationPointList.size();
        return average;
    }

    public LinkedList<Double> getEvaluationPointList() {
        return this.evaluationPointList;
    }

}
