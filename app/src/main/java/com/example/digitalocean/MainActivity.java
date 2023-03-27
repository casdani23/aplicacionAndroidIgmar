package com.example.digitalocean;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText input_codigo =  (EditText) findViewById(R.id.input_codigo);
        Button myButton =  (Button) findViewById(R.id.input_codigobutton);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);


        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    myButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String url = "https://danielcas.online/api/codigoapp";
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                    response -> {
                                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                                    },
                                    error -> {
                                        Toast.makeText(MainActivity.this,"estas en el dominio", Toast.LENGTH_SHORT).show();;
                                    }) {
                                @Override
                                protected Map<String, String> getParams() {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("input_codigo", input_codigo.getText().toString());
                                    return params;
                                }

                            };
                            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                            queue.add(stringRequest);
                        }


                    });


                } else if(!isChecked) {

                    myButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            String url = "http://10.20.0.4/api/codigoapp";
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                    response -> {
                                        Toast.makeText(MainActivity.this, response, Toast.LENGTH_SHORT).show();
                                    },
                                    error -> {
                                        Toast.makeText(MainActivity.this,"estas en la vpn", Toast.LENGTH_SHORT).show();;
                                    }) {
                                @Override
                                protected Map<String, String> getParams() {
                                    Map<String, String> params = new HashMap<String, String>();
                                    params.put("input_codigo", input_codigo.getText().toString());
                                    return params;
                                }

                            };
                            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                            queue.add(stringRequest);
                        }


                    });




                }
            }
        });




    }

}