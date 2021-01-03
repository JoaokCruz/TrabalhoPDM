package com.progdispmov.trabalhopdm;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ConexaoDB{


    public void Inserir( final Context context ){
       RequestQueue queue = Volley.newRequestQueue(context);
       String url ="http://teyis.pythonanywhere.com/register";
       StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show();
           }
       }) {
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String, String> params = new HashMap<String, String>();
               params.put("name", "joao");
               params.put("email", "joao@gmail.com");
               params.put("senha", "123");

               return params;
           }

//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("Content-Type","application/x-www-form-urlencoded");
//                return params;
//            }
       };
       queue.add(sr);
   }
}
