package company.my.semer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import company.my.semer.parsers.MaterialParsing;

public class interface_admin extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_admin);
        Intent intent = getIntent();
        Button add = (Button) findViewById(R.id.buttonAjout);
        String id = intent.getStringExtra("stationselectedid");
        ArrayList<Materiel> stations = new ArrayList<Materiel>();
        MaterialParsing stationParsing = new MaterialParsing();

        try {
            stations = stationParsing.execute("http://10.0.3.2:18080" +
                    "/BanqueJsf-web/rest/finance","1").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
      /*  Log.e("station :", station.getId() + "");
        Log.e("station :", station.getStartDate() + "");*/
        ListView l = (ListView) findViewById(R.id.listViewMaterial);
        ArrayAdapter<Materiel> adapter = new ArrayAdapter<Materiel>(this, android.R.layout.simple_list_item_1, stations);
        l.setAdapter(adapter);
        //Log.e("station :", station.getTypeStation()+"");
        // Log.e("station :", station.getLongitude()+"");
        //Log.e("station :", station.getLatitude()+"");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(interface_admin.this, AddMaterial.class);
                startActivity(i);
            }
        });
    }


}
