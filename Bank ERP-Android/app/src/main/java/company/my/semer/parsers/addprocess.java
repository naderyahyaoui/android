package company.my.semer.parsers;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import company.my.semer.Client;

/**
 * Created by zouabi on 09/11/2015.
 */
public class addprocess extends AsyncTask<Client, Void,Void> {
    @Override
    protected Void doInBackground(Client... params) {
        JSONObject json = new JSONObject();
        try {
            json.put("idUser", params[0].getIdUser());
            json.put("firstName", params[0].getFirstName());
            json.put("lastName", params[0].getLastName());
            json.put("mail", params[0].getMail());
            json.put("etatCivil", params[0].getEtatCivil());
            json.put("tel", params[0].getTel());
            json.put("cin", params[0].getCin());
            json.put("password", params[0].getPassword());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpPut httpPut = new HttpPut("http://10.0.3.2:18080/BanqueJsf-web/rest/client/modifier");

        StringEntity a = null;
        try {
            a = new StringEntity(json.toString());
            httpPut.setEntity(a);
            httpPut.addHeader("content-type","application/json");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            httpResponse = httpClient.execute(httpPut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
