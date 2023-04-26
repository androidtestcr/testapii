package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity6 extends AppCompatActivity {
EditText ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6); ed=findViewById(R.id.edhh1);
    }


    public void supprh(View v){

        OkHttpClient client = new OkHttpClient();
  String adr = "http://192.168.11.100/bd/supprh.php";
        HttpUrl.Builder url= HttpUrl.parse(adr).newBuilder();

        url.addQueryParameter("idh",ed.getText().toString());
        String urll = url.build().toString();
        Request rq= new Request.Builder().url(urll).build();


        client.newCall(rq).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                MainActivity6.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity6.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                final String rp= response.body().string();
              MainActivity6.this.runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      Toast.makeText(MainActivity6.this, rp, Toast.LENGTH_SHORT).show();}});}
        });
    }
}