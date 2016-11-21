package company.my.semer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import company.my.semer.parsers.addprocess;

public class ModifyClientGUI extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_client_gui);

        Client c = new Client();

        c.setIdUser(2);

        Button b = (Button) findViewById(R.id.clientbutton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstnam = (EditText) findViewById(R.id.clientfirstname);
                EditText lastnam = (EditText) findViewById(R.id.clientLastname);
                EditText cin = (EditText) findViewById(R.id.clientcin);
                EditText etatciv = (EditText) findViewById(R.id.clientetatcivil);
                EditText mail = (EditText) findViewById(R.id.clientmail);
                EditText tel = (EditText) findViewById(R.id.clienttelephone);
                EditText pass = (EditText) findViewById(R.id.clientpass);

                Client cmodif = new Client();
                cmodif.setIdUser(2);
                cmodif.setCin(Integer.parseInt(cin.getText().toString()));
                cmodif.setLastName(lastnam.getText().toString());
                cmodif.setEtatCivil(etatciv.getText().toString());
                cmodif.setMail(mail.getText().toString());
                cmodif.setFirstName(firstnam.getText().toString());
                cmodif.setTel(tel.getText().toString());
                cmodif.setPassword(pass.getText().toString());




                addprocess addprocessaaa = new addprocess();

                addprocessaaa.execute(cmodif);
            }
        });



    }

}
