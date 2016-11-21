package company.my.semer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcceuilActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        final Button Buttoncpt = (Button) findViewById(R.id.buttoncpt);
        Buttoncpt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilActivity.this, comptActivity.class);
                startActivity(intent);
            }
        });
        final Button ButtonA = (Button) findViewById(R.id.buttonAcceuil);
        ButtonA.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilActivity.this, interface_admin.class);
                startActivity(intent);
            }
        });

        final Button Conta = (Button) findViewById(R.id.buttonContact);
        Conta.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AcceuilActivity.this, Contact.class);
                startActivity(intent);
            }
        });

    }

}
