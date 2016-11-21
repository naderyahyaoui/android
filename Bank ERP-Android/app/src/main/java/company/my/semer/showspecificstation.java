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

import company.my.semer.parsers.StationParsing;
/**
 * Created by aymen on 08/11/2015.
 */
public class showspecificstation extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showspecificstation);
        Intent intent = getIntent();
        String id = intent.getStringExtra("stationselectedid");

        ArrayList<Client> stations = new ArrayList<Client>();
        StationParsing stationParsing = new StationParsing();
        Button modif = (Button) findViewById(R.id.modifinfo);
        try {
            stations = stationParsing.execute("http://10.0.3.2:18080" +
                    "/BanqueJsf-web/rest/client","1").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
      /*  Log.e("station :", station.getId() + "");
        Log.e("station :", station.getStartDate() + "");*/
        ListView l = (ListView) findViewById(R.id.lv1111);
        ArrayAdapter<Client> adapter = new ArrayAdapter<Client>(this, android.R.layout.simple_list_item_1, stations);
        l.setAdapter(adapter);
        //Log.e("station :", station.getTypeStation()+"");
        // Log.e("station :", station.getLongitude()+"");
        //Log.e("station :", station.getLatitude()+"");

        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(showspecificstation.this, ModifyClientGUI.class);
                startActivity(i);

            }
        });
    }
}
