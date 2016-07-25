/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

/**
 *
 * @author liufangyang
 */
public class DateFormaterUtil {

    public static Date StringToDate(String date) {

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date result = df.parse(date);
            return result;

        } catch (ParseException e) {

        }
        return null;
    }

    public static String DateToString(Date date) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String result = df.format(date);
        return result;
    }
}
