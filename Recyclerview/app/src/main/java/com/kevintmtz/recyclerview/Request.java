package com.kevintmtz.recyclerview;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Handler;

import javax.net.ssl.HttpsURLConnection;

public class Request extends Thread {

    private String url;
    private Handler handler;

    public Request(String url, Handler handler) {
        this.url = url;
        this.handler = handler;
    }

    public void run() {
        try {
            URL address = new URL(url);

            HttpsURLConnection connection = (HttpsURLConnection) address.openConnection();

            int code = connection.getResponseCode();
            if (code == HttpsURLConnection.HTTP_OK) {

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
