package company.my.semer.parsers;

/**
 * Created by Faycel M'rabet on 10/11/2015.
 */
import android.os.AsyncTask;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import company.my.semer.Materiel;

/**
 * Created by aymen on 09/11/2015.
 */
public class MaterialAdd extends AsyncTask<String, Void, ArrayList<Materiel>> {
    @Override
    protected ArrayList<Materiel> doInBackground(String... params) {
        List<NameValuePair> paramss;
        ServiceHandler sh = new ServiceHandler();
        paramss = new ArrayList<NameValuePair>();
        paramss.add(new BasicNameValuePair("price",""));
        paramss.add(new BasicNameValuePair("qte",""));
        paramss.add(new BasicNameValuePair("description",""));
        paramss.add(new BasicNameValuePair("type",""));
        paramss.add(new BasicNameValuePair("id_F",""));

        sh.makeServiceCall("http://10.0.3.2:18080" +"/BanqueJsf-web/rest/finance",3,paramss);
        return null;
    }

}
