package company.my.semer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMaterial extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_material);
        Button b = (Button) findViewById(R.id.buttonSubmit);
        EditText price=(EditText)findViewById(R.id.pricetxt);
        EditText desc=(EditText)findViewById(R.id.descriptiontxt);
        EditText qte=(EditText)findViewById(R.id.qtetxt);
        EditText type=(EditText)findViewById(R.id.typetxt);

        final EditText e = (EditText) findViewById(R.id.pricetxt);
        final EditText e1 = (EditText) findViewById(R.id.descriptiontxt);
        final EditText e2 = (EditText) findViewById(R.id.qtetxt);
        final EditText e3 = (EditText) findViewById(R.id.typetxt);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Materiel d = new Materiel();
                d.setPrice(Float.parseFloat(e.getText().toString()));
                d.setDescription(e1.getText().toString());
                d.setQte(Integer.parseInt(e2.getText().toString()));
                d.setType(e3.getText().toString());

                AddMaterialProcess addDealsProcess = new AddMaterialProcess();
                addDealsProcess.execute(d);

            }
        });
    }

}

