package company.my.semer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class typeAccountShActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_account_sh);





        final Button ButtonBusiness = (Button) findViewById(R.id.buttonb);
        ButtonBusiness.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(typeAccountShActivity.this, AffActivity.class);
                startActivity(intent);
            }
        });

        final Button ButtonEp = (Button) findViewById(R.id.buttonep);
        ButtonEp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(typeAccountShActivity.this, AffEpActivity.class);
                startActivity(intent);
            }
        });
        final Button Buttonc = (Button) findViewById(R.id.buttonc);
        Buttonc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(typeAccountShActivity.this, AffCouActivity.class);
                startActivity(intent);
            }
        });
        final Button Buttonm = (Button) findViewById(R.id.buttonm);
        Buttonm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(typeAccountShActivity.this, AffMActivity.class);
                startActivity(intent);
            }
        });


    }
}
