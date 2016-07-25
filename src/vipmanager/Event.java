package vipmanager;

import java.util.Date;
import java.util.LinkedList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author liufangyang
 */
public class Event {

    private int eventId;
    private Date eventDate;
    private String eventName;
    private String description;
    private LinkedList<Vip> registedVipList = new LinkedList<Vip>();
    private static int idCount = 1;

    public Event(Date date, String eventName, String description) {
        this.eventId = idCount;
        this.eventDate = date;
        this.eventName = eventName;
        this.description = description;
        idCount++;
    }

    public int getId() {
        return this.eventId;
    }

    public String getName() {
        return this.eventName;
    }

    public boolean addToRegistedVipList(Vip vip) {
        for (int i = 0; i < registedVipList.size(); i++) {
            if (vip.equals(registedVipList.get(i))) {
                return false;
            }
        }
        registedVipList.add(vip);
        return true;
    }

    public String toString() {

        return String.format("%-15d%-15s%-20s%-15s", eventId,
                DateFormaterUtil.DateToString(eventDate), eventName, description);
    }

    public String toStringIncludingVip() {
        String id = "";
        for (int i = 0; i < registedVipList.size(); i++) {

            id += Integer.toString(registedVipList.get(i).getId()) + ",";

        }
        String result = String.format("%-15d%-15s%-20s%-15s%-15s", eventId,
                DateFormaterUtil.DateToString(eventDate), eventName, description, id);
        return result;
    }
}
