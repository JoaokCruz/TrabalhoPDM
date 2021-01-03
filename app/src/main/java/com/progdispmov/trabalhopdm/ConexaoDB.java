package com.progdispmov.trabalhopdm;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ConexaoDB{


    public void Login( final Context context, final LoginActivity activity,final String email, final String password ){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://teyis.pythonanywhere.com/login";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject jsonObject = new JSONObject();
                try{
                    jsonObject = new JSONObject( response );
                }catch (JSONException err){
                    Log.d("Error", err.toString());
                }
                activity.Login( jsonObject );
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Usuário não encontrado!", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("email", email);
                params.put("senha", password);

                return params;
            }

        };
        queue.add(sr);
    }

    public void Register( final Context context, final SigninActivity activity, final String name, final String email, final String password ){
       RequestQueue queue = Volley.newRequestQueue(context);
       String url ="http://teyis.pythonanywhere.com/register";
       StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               Toast.makeText(context, "Registro feito com sucesso!", Toast.LENGTH_SHORT).show();
               activity.toLogin();
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
           }
       }) {
           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String, String> params = new HashMap<String, String>();
               params.put("name", name);
               params.put("email", email);
               params.put("senha", password);

               return params;
           }

       };
       queue.add(sr);
   }
    public void RegisterEntry( final Context context, final NewRecordActivity activity, final String data, final String local, final Integer usuario_id ){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://teyis.pythonanywhere.com/registerEntry";
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                activity.startScanning(Integer.valueOf( response ));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("data", data);
                params.put("local", local);
                params.put("usuario_id", String.valueOf( usuario_id ));

                return params;
            }

        };
        queue.add(sr);
    }

    public void RegisterGeolocal( final Context context, final String latitude, final String longitude, final Integer registro_id ){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://teyis.pythonanywhere.com/registerGeolocal";
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
                params.put("latitude", latitude);
                params.put("longitude", longitude);
                params.put("registro_id", String.valueOf( registro_id ));

                return params;
            }

        };
        queue.add(sr);
    }


}
