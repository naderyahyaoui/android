package company.my.semer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

import company.my.semer.parsers.Authentification;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // Button b = (Button) findViewById(R.id.button2);
      //  Button bmodif = (Button) findViewById(R.id.buttonmodif);
        Button bauthentif = (Button ) findViewById(R.id.buttonlogin);

        bauthentif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText) findViewById(R.id.authentiffirstname);
                EditText e1 = (EditText) findViewById(R.id.authentifpass);

                Client c = new Client();
                c.setIdUser(2);
                c.setFirstName(e.getText().toString());
                c.setPassword(e1.getText().toString());
                Authentification authentification = new Authentification();

                String result = null;
                try {
                    result = authentification.execute(c).get();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (ExecutionException e2) {
                    e2.printStackTrace();
                }
                if(result.equals("exist")) {
                    if(c.getFirstName().equals("admin")&&c.getPassword().equals("admin"))
                    {
                        Intent i = new Intent(MainActivity.this, AcceuilActivity.class);
                        startActivity(i);
                    }
                    else{
                        Intent i = new Intent(MainActivity.this, showspecificstation.class);
                        startActivity(i);
                    }


                }

            }
        });






        // bmodif.setOnClickListener(new View.OnClickListener() {
        //    @Override
         //   public void onClick(View v) {

          //      Intent i = new Intent(MainActivity.this, ModifyClientGUI.class);
          //      startActivity(i);
              /*  Client c = new Client();
                c.setTel("2");
                c.setIdUser(2);
                c.setLastName("b");
                c.setCin(2);

                addprocess addprocessaaa = new addprocess();

                addprocessaaa.execute(c);*/

          //  }
       // });
    }
}
