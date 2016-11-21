package company.my.semer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by esprit on 10/11/2015.
 */
public class Contact extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_main);
        //buttonM = (Button) findViewById(R.id.buttonMail);
        Button M = (Button) findViewById(R.id.buttonMail);
    Button SMS = (Button) findViewById(R.id.buttonSMS);

       SMS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
              //  Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                    //    .setAction("Action", null).show();
              //  startActivity(new Intent(Contact.this, EnvoieSms.class));
               Intent i = new Intent(Contact.this, EnvoieSms.class);
                startActivity(i);
            }
        });

/*
     M.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
             //  Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG)
                     //  .setAction("Action", null).show();
              // startActivity(new Intent(Contact.this, MainActivityY.class));
               Intent i = new Intent(Contact.this, showspecificstation.class);
               startActivity(i);

           }
       });*/
        M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Contact.this, MainActivityY.class);
                startActivity(i);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
          //  return true;
      //  }

        return super.onOptionsItemSelected(item);
    }

}
