package company.my.semer.parsers;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import company.my.semer.Client;

/**
 * Created by Faycel M'rabet on 10/11/2015.
 */
public class Authentification extends AsyncTask<Client, Void,String> {
    static String response = null;


    @Override
    protected String doInBackground(Client... params) {
        JSONObject json = new JSONObject();
        try {
            json.put("idUser", params[0].getIdUser());
            json.put("password", params[0].getPassword());
            json.put("firstName", params[0].getFirstName());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpPost httpGet = new HttpPost("http://10.0.3.2:18080/BanqueJsf-web/rest/client/authentification");

        StringEntity a = null;
        try {
            a = new StringEntity(json.toString());
            httpGet.setEntity(a);
            httpGet.addHeader("content-type","application/json");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpEntity = httpResponse.getEntity();
        try {
            response = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }


}
