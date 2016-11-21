package company.my.semer;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import company.my.semer.utils.HelperHttp;

/**
 * Created by ji on 08/11/2015.
 */
public class JsonFragment extends Fragment {


    ListView lvClients;
    ClientAdapter clientAdapter;
    List<Client> clients = new ArrayList<Client>();

    String URL = "http://10.0.3.2:18080/MaTacheBanque-web/rest/client";

    public JsonFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_json, container,
                false);
        lvClients = (ListView) rootView.findViewById(R.id.lv_Clients);

        new AsycGetClients().execute();
        lvClients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), clients.get(position).getFirstName(), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }


    void parseJsonClients(List<Client> clients, String json) {
        try {
            JSONArray array = new JSONArray("");
//			for (int i = 0; i < array.length(); i++) {
//				JSONObject j = array.getJSONObject(i);
//				Teacher teacher = new Teacher();
//
//				teacher.setId(j.optInt("id"));
//				teacher.setGivenName(j.optString("givenName"));
//				teacher.setLastName(j.optString("lastName"));
//				teacher.setClassName(j.optString("className"));
//				teacher.setImgPath(j.optString("imgPath"));
//				teachers.add(teacher);
//						}
            for (int i = 0; i < array.length(); i++) {
                JSONObject j = array.getJSONObject(i);
                Client client = null;
                ObjectMapper objectMapper = new ObjectMapper();
                try {
                    client = objectMapper.readValue(j.toString(),
                            Client.class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                clients.add(client);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



    class AsycGetClients extends AsyncTask<String, Void, String> {
        ProgressDialog barProgressDialog = new ProgressDialog(getActivity());


        @Override
        protected void onPreExecute() {

            barProgressDialog.setTitle("Loading ...");
            barProgressDialog.setMessage("Load Data in progress ...");
            barProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            barProgressDialog.show();

            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {

            String jsonClientList = HelperHttp
                    .getJSONResponseFromURL(URL);
            parseJsonClients(clients, jsonClientList);

            return null;
        }

        @Override
        protected void onPostExecute(String result) {

            clientAdapter = new ClientAdapter(getActivity(),
                    R.layout.client_details_row, clients);
            lvClients.setAdapter(clientAdapter);
            barProgressDialog.dismiss();

            super.onPostExecute(result);
        }
    }


}