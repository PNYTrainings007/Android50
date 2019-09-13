package com.pny.android50;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VolleyActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    String url = "https://demonuts.com/Demonuts/JsonTest/Tennis/json_parsing.php";

    String sendUrl = "http://epay.cybussolutions.com/Api_Service/signupUser";

    RecyclerView tennisPlayerRV;

    ArrayList<Player> players= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);

        tennisPlayerRV = findViewById(R.id.tennisPlayerRV);

        RecyclerView.LayoutManager manager =new  LinearLayoutManager(this);
        tennisPlayerRV.setLayoutManager(manager);

        requestQueue = Volley.newRequestQueue(this);

        fetchDataFromServer();

    }


    public void fetchDataFromServer() {

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ParseJson(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(request);

    }

    public void sendDataToServer(){

        StringRequest request = new StringRequest(Request.Method.POST, sendUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(VolleyActivity.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(VolleyActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String ,String > map = new HashMap<>();

                map.put("email", "remote12345@yahoo.com");
                map.put("first_name", "white");
                map.put("last_name", "red");
                map.put("password", "1234");
                map.put("phone_number", "00000");
                map.put("address", "house 10 street 100");
                map.put("gender", "2");
                map.put("cardtype", "0");

                return map;
            }
        };

        requestQueue.add(request);
    }

    public void ParseJson(String response) {

        try {
            JSONObject object = new JSONObject(response);

            JSONArray data = object.getJSONArray("data");

            for (int i = 0; i < data.length(); i++) {

                JSONObject playerObj = data.getJSONObject(i);

                Player  player = new Player();

                player.setName(playerObj.optString("name",""));
                player.setId(playerObj.optString("id",""));
                player.setCity(playerObj.optString("city",""));
                player.setCountry(playerObj.optString("country",""));
                player.setImgURL(playerObj.optString("imgURL",""));

                players.add(player);

            }

            TennisAdapter tennisAdapter = new TennisAdapter(this,players);
            tennisPlayerRV.setAdapter(tennisAdapter);

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
