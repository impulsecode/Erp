package com.yunshu.utils;

/**
 * Created by Administrator on 2018/5/18.
 */

public final class TextUtils {

    public TextUtils() {
    }

    public static boolean isEmpty(CharSequence s) {
        return s == null ? true : s.length() == 0;
    }

    public static boolean isBlank(CharSequence s) {
        if (s == null) {
            return true;
        } else {
            for (int i = 0; i < s.length(); ++i) {
                if (!Character.isWhitespace(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static Boolean isNullOrEmpty(String target) {
        return target == null || target.length() == 0;
    }
}

