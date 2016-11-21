package company.my.semer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class comptActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compt);


        final Button shButton = (Button) findViewById(R.id.shButton);
        shButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(comptActivity.this, typeAccountShActivity.class);
                startActivity(intent);
            }
        });


        final Button AddButton = (Button) findViewById(R.id.AddButton);
        AddButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(comptActivity.this, TypeAddActivity.class);
                startActivity(intent);
            }
        });



    }
}
