package company.my.semer;
import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by zouabi on 09/11/2015.
 */
public class AddMaterialProcess extends AsyncTask<Materiel, Void,Void> {
    @Override
    protected Void doInBackground(Materiel... params) {
        JSONObject json = new JSONObject();
        try {
            json.put("price", params[0].getPrice());
            json.put("qte", params[0].getQte());
            json.put("description", params[0].getDescription());
            json.put("type", params[0].getType());

        } catch (JSONException e) {
            e.printStackTrace();
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost("http://10.0.3.2:18080/BanqueJsf-web/rest/finance");

        StringEntity a = null;
        try {
            a = new StringEntity(json.toString());
            httpPost.setEntity(a);
            httpPost.addHeader("content-type","application/json");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
