package com.kevintmtz.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpRequestActivity extends AppCompatActivity implements Handler.Callback{

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_request);

        handler =  new Handler(Looper.getMainLooper(), this);

        String json1 = "{'name': 'Kevin', 'age': 20, 'pet': {'name': 'Juanin', 'species': 'Hamster'}}";
        String json2 = "{'name': 'Nat', 'age': 21, 'grades': [100, 99, 98]}";

        try {
            JSONObject object1 = new JSONObject(json1);
            Toast.makeText(this, object1.getJSONObject("pet").getString("name"), Toast.LENGTH_SHORT).show();

            JSONObject object2 = new JSONObject(json2);
            JSONArray array = object2.getJSONArray("grades");
            Toast.makeText(this, array.getString(0), Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void makeHttpRequest(View view) {
        HttpRequest request = new HttpRequest("https://api.github.com/users", handler);
        request.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        JSONArray data = (JSONArray) msg.obj;
        Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show();

        return true;
    }
}