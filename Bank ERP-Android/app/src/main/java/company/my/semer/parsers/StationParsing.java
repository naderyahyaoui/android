package company.my.semer.parsers;


import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import company.my.semer.Client;
/**
 * Created by zouabi on 06/11/2015.
 */
public class StationParsing extends AsyncTask<String, Void, ArrayList<Client>> {
    @Override
    protected ArrayList<Client> doInBackground(String... params) {
        ArrayList<Client> stations= new ArrayList<Client>();
        ServiceHandler sh = new ServiceHandler();
        if (params != null) {
            try {
                String result = sh.makeServiceCall(params[0], Integer.parseInt(params[1]));
                JSONArray jsonarray = new JSONArray(result);
                // looping through All Lines
                for (int i = 0; i < 1; i++) {
                    JSONObject jsonobj = jsonarray.getJSONObject(i);
                    //Station attributes
                    Client station = new Client();
                    //Parsing



                    station.setIdUser(jsonobj.getInt("idUser"));
                    station.setFirstName(jsonobj.getString("firstName"));
                    station.setLastName(jsonobj.getString("lastName"));
                    station.setTel(jsonobj.getString("tel"));
                    station.setMail(jsonobj.getString("mail"));
                    station.setCin(jsonobj.getInt("cin"));
                    station.setEtatCivil(jsonobj.getString("etatCivil"));
                    station.setPassword(jsonobj.getString("password"));

                    ;
                    stations.add(station);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } else {
            Log.e("ServiceHandler", "Couldn't get any data from the url");
        }
        return stations;
    }
}
