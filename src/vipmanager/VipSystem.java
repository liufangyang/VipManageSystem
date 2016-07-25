/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.util.LinkedList;

/**
 *
 * @author liufangyang
 */
public class VipSystem {

    private static LinkedList<Vip> vipList = new LinkedList<Vip>();
    private static LinkedList<Event> eventList = new LinkedList<Event>();
    private static LinkedList<Coupon> couponList = new LinkedList<Coupon>();
    private static LinkedList<Product> productList = new LinkedList<Product>();
    private static LinkedList<ProductEvaluationRecord> productEvaluationRecordList = new LinkedList<ProductEvaluationRecord>();
    private static LinkedList<TransactionRecord> transactionRecordList = new LinkedList<TransactionRecord>();
    private static String adminPassword = "kungfutea";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WelcomeGUI wg = new WelcomeGUI();
        wg.setVisible(true);

    }

    public static LinkedList<Vip> getVipList() {
        return vipList;
    }

    public static LinkedList<Event> getEventList() {
        return eventList;
    }

    public static LinkedList<Coupon> getCouponList() {
        return couponList;
    }

    public static LinkedList<Product> getProductList() {
        return productList;
    }

    public static LinkedList<TransactionRecord> getTransactionRecordList() {
        return transactionRecordList;
    }

    public static LinkedList<ProductEvaluationRecord> getProductEvaluationRecordList() {
        return productEvaluationRecordList;
    }

    public static void addToVipList(Vip vip) {
        vipList.add(vip);
    }

    public static void addToEventList(Event event) {
        eventList.add(event);
    }

    public static void addToCouponList(Coupon coupon) {
        couponList.add(coupon);
    }

    public static void addToProductList(Product product) {
        productList.add(product);
    }

    public static void addToProductEvaluationRecordList(ProductEvaluationRecord productEvaluationRecord) {
        productEvaluationRecordList.add(productEvaluationRecord);
    }

    public static void addToTransactionRecordList(TransactionRecord transactionRecord) {
        transactionRecordList.add(transactionRecord);
    }

    public static Vip searchVipByName(String name) {
        if (name.equals("")) {
            return null;
        }
        for (int i = 0; i < vipList.size(); i++) {
            if (vipList.get(i) == null) {
                return null;
            }
            if (name.equals(vipList.get(i).getFullName())) {
                return vipList.get(i);
            }
        }
        return null;
    }

    public static Product searchProductByName(String name) {
        if (name.equals("")) {
            return null;
        }
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i) == null) {
                return null;
            }
            if (name.equals(productList.get(i).getProductName())) {
                return productList.get(i);
            }
        }
        return null;
    }

    public static Vip getVipById(int id) {
        for (int i = 0; i < vipList.size(); i++) {
            if (vipList.get(i).getId() == id) {
                return vipList.get(i);
            }
        }
        return null;
    }

    public static Event getEventByid(int id) {
        for (int i = 0; i < eventList.size(); i++) {
            if (eventList.get(i).getId() == id) {
                return eventList.get(i);
            }
        }
        return null;
    }

    public static void removeEventByEvent(Event e) {
        eventList.remove(e);

    }

    public static Coupon getCouponById(int id) {
        for (int i = 0; i < couponList.size(); i++) {
            if (couponList.get(i).getId() == id) {
                return couponList.get(i);
            }
        }
        return null;

    }

    public static boolean checkAdminPassword(String password) {
        return password.equals(adminPassword);

    }

    public static LinkedList<Coupon> getCouponByVip(Vip vip) {
        LinkedList<Coupon> vipCouponList = new LinkedList<Coupon>();
        for (int i = 0; i < couponList.size(); i++) {
            if (couponList.get(i).getVip().equals(vip)) {
                vipCouponList.add(couponList.get(i));
            }
        }
        return vipCouponList;

    }

    public static ProductEvaluationRecord getProductEvaluationRecordByProduct(Product product) {
        for (int i = 0; i < productEvaluationRecordList.size(); i++) {
            if (product.getProductId() == productEvaluationRecordList.get(i).getProduct().getProductId()) {
                return productEvaluationRecordList.get(i);
            }
        }
        return null;
    }

    public static Product getProductById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    public static Coupon searchCouponByName(String name) {
        for (int i = 0; i < couponList.size(); i++) {
            if (name.equals(couponList.get(i).getCouponName())) {
                return couponList.get(i);
            }
        }
        return null;
    }

    public static LinkedList<TransactionRecord> getVipTransactionListByVip(Vip vip) {
        LinkedList<TransactionRecord> vipTransactionRecordList = new LinkedList<TransactionRecord>();
        for (int i = 0; i < transactionRecordList.size(); i++) {
            if (transactionRecordList.get(i).getVip().getId() == vip.getId()) {
                vipTransactionRecordList.add(transactionRecordList.get(i));
            }
        }
        return vipTransactionRecordList;
    }

    public static Product getMaxSoldProductByProductList(LinkedList<Product> productList) {
        int max = 0, j = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (i == 0) {
                max = productList.get(i).getQuantityBeenSold();
            }
            max = Math.max(productList.get(i).getQuantityBeenSold(), max);
            j = i;
        }
        return productList.get(j);
    }

    public static Product getPopularDrinkByGender(String gender) {
        LinkedList<TransactionRecord> trList = VipSystem.getTransactionRecordList();
        LinkedList<TransactionRecord> maleList = new LinkedList<TransactionRecord>();
        LinkedList<Product> productList = new LinkedList<Product>();
        for (int i = 0; i < trList.size(); i++) {
            if (trList.get(i).getVip().getGender().equals(gender)) {
                maleList.add(trList.get(i));
            }
        }
        for (int i = 0; i < maleList.size(); i++) {
            productList.add(maleList.get(i).getProduct());
        }
        Product product = VipSystem.getMaxSoldProductByProductList(productList);
        return product;
    }
}
