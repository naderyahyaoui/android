package company.my.semer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TypeAddActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_add);

        setContentView(R.layout.activity_type_add);
        final Button buttonepadd = (Button) findViewById(R.id.buttonepadd);
        buttonepadd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TypeAddActivity.this, AddCourantActivity.class);
                startActivity(intent);
            }
        });

    }
}
