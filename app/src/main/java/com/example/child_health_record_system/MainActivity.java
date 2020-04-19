package com.example.child_health_record_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView logintext = findViewById(R.id.textView);
        logintext.setText("Wpisz swój login");
        TextView passtext = findViewById(R.id.textView2);
        passtext.setText("Wpisz swoje hasło");

        final EditText loginedit = findViewById(R.id.editText3);
        final EditText passedit = findViewById(R.id.editText4);

        Button loginbutt = findViewById(R.id.button);


        loginbutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject logindata = new JSONObject();
                String user_login = loginedit.getText().toString();
                String user_pass = passedit.getText().toString();
                if (user_login != "" && user_pass != "") {
                    try {
                        logindata.put("login", user_login);
                        logindata.put("password", user_pass);
                        Log.e("TAG", logindata.toString());
                        new SendJSONtoServer().execute("http://192.168.0.66:8080/dzienniczek-serwer/servletdata", logindata.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
