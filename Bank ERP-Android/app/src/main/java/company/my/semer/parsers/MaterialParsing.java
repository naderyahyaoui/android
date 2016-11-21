package company.my.semer.parsers;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import company.my.semer.Materiel;

/**
 * Created by Faycel M'rabet on 10/11/2015.
 */
public class MaterialParsing extends AsyncTask<String, Void, ArrayList<Materiel>>{

        @Override
        protected ArrayList<Materiel> doInBackground(String... params) {
            ArrayList<Materiel> stations = new ArrayList<Materiel>();
            ServiceHandler sh = new ServiceHandler();
            if (params != null) {
                try {
                    String result = sh.makeServiceCall(params[0], Integer.parseInt(params[1]));
                    JSONArray jsonarray = new JSONArray(result);
                    // looping through All Lines
                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobj = jsonarray.getJSONObject(i);
                        //Station attributes
                        Materiel station = new Materiel();
                        //Parsing
                        station.setIdM(jsonobj.getInt("idM"));
                        station.setDescription(jsonobj.getString("description"));
                        station.setPath(jsonobj.getString("path"));
                        station.setPrice(jsonobj.getInt("price"));
                        station.setQte(jsonobj.getInt("qte"));
                        station.setType(jsonobj.getString("type"));
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

