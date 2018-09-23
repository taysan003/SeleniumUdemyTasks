package com.findlinks;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class GetResponseCode {

    static  int inValidLink;

    public static void verifyUrl(String linkURL){
        try {
            URL url = new URL(linkURL);
            HttpsURLConnection urlConnect = (HttpsURLConnection) url.openConnection();
            urlConnect.setConnectTimeout(5000); // set connection timeout faiting for 5 sec for response
            urlConnect.connect(); //open communication link to responce URL
            if (urlConnect.getResponseCode() == 200) {
                System.out.println(
                        linkURL + " : " + urlConnect.getResponseCode() + " : " + urlConnect.getResponseMessage());
            } else if (urlConnect.getResponseCode() == urlConnect.HTTP_NOT_FOUND) {
                System.out
                        .println(linkURL + " : " + urlConnect.getResponseMessage() + " : " + urlConnect.HTTP_NOT_FOUND);
                inValidLink++;
            }

        } catch (Exception e) {
        }
    }

    public static void getInvalidLinkCount() {
        System.out.println("Total Invalid Links : " + inValidLink);
    }
}
