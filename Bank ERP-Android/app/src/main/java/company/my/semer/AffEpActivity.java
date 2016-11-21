package company.my.semer;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import company.my.semer.parsers.ServiceHandler;

public class AffEpActivity extends ListActivity {
    private ProgressDialog pDialog;

    // URL to get contacts JSON
    private static String url = "http://192.168.1.2:18080/ProjetBanque-web/rest/compte";

    // JSON Node names

    private static final String TAG_ID = "idCompte";
    private static final String TAG_NAME = "solde";
    //private static final String TAG_EMAIL = "qte";
    private static final String TAG_ADDRESS = "ville";
    //private static final String TAG_GENDER = "path";
    //private static final String TAG_PHONE = "type";
//    private static final String TAG_PHONE_MOBILE = "ville";


    // contacts JSONArray
    JSONArray contacts = null;

    // Hashmap for ListView
    ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aff_ep);
        contactList = new ArrayList<HashMap<String, String>>();

        ListView lv = getListView();
        // Calling async task to get json
        new GetContacts().execute();
    }
    /**
     * Async task class to get json by making HTTP call
     */
    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(AffEpActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            // Creating service handler class instance
            ServiceHandler sh = new ServiceHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

            Log.d("Response: ", "> " + jsonStr);

            if (jsonStr != null) {
                try {
                    //JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    //contacts = jsonObj.getJSONArray("");
                    JSONArray contacts = new JSONArray(jsonStr);
                    // looping through All Contacts
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);

                        String id = c.getString(TAG_ID);
                        String name = c.getString(TAG_NAME);
                        //    String email = c.getString(TAG_PHONE_MOBILE);
                        String address = c.getString(TAG_ADDRESS);
                        //String gender = c.getString(TAG_GENDER);


                        // tmp hashmap for single contact
                        HashMap<String, String> contact = new HashMap<String, String>();

                        // adding each child node to HashMap key => value
                        contact.put(TAG_ID, id);
                        contact.put(TAG_NAME, name);
                        contact.put(TAG_ADDRESS, address);
                        //      contact.put(TAG_PHONE_MOBILE, mobile);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Log.e("ServiceHandler", "Couldn't get any data from the url");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */
            ListAdapter adapter = new SimpleAdapter(
                    AffEpActivity.this, contactList,
                    R.layout.list_item, new String[]{TAG_NAME,
                    TAG_ADDRESS, TAG_ID}, new int[]{R.id.name,
                    R.id.email, R.id.mobile});

            setListAdapter(adapter);
        }

    }
}
