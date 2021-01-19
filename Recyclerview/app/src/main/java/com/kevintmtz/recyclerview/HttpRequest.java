package com.kevintmtz.recyclerview;

import android.os.Message;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import android.os.Handler;

import javax.net.ssl.HttpsURLConnection;

public class HttpRequest extends Thread {

    private String url;
    private Handler handler;

    public HttpRequest(String url, Handler handler) {
        this.url = url;
        this.handler = handler;
    }

    public void run() {
        try {
            URL address = new URL(url);

            HttpsURLConnection connection = (HttpsURLConnection) address.openConnection();

            int code = connection.getResponseCode();
            if (code == HttpsURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuilder stringBuilder = new StringBuilder();
                String currentLine;

                while((currentLine = bufferedReader.readLine()) != null) {
                    stringBuilder.append(currentLine);
                }

                String json = stringBuilder.toString();

                JSONArray requestResult = new JSONArray(json);

                Message message = new Message();
                message.obj = requestResult;
                handler.sendMessage(message);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
