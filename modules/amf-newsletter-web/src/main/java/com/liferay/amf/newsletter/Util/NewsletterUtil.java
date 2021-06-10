package com.liferay.amf.newsletter.Util;

public class NewsletterUtil {

    public static String splitDate(String date, int index) {
        String[] parts = date.split("-");

        return parts[index];
    }
}
