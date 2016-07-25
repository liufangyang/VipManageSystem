/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vipmanager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author liufangyang
 */
public class RegexUtil {

    public static boolean isNumber(String input) {
        boolean isMatch;
        Pattern p = Pattern.compile("^[0-9]*$");
        Matcher m = p.matcher(input);
        isMatch = m.matches();
        return isMatch;
    }

    public static boolean isLetter(String input) {
        boolean isMatch;
        Pattern p = Pattern.compile("^[A-Za-z]+$");
        Matcher m = p.matcher(input);
        isMatch = m.matches();
        return isMatch;
    }
}
