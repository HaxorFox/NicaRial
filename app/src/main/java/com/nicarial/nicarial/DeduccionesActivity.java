package com.nicarial.nicarial;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class DeduccionesActivity extends AppCompatActivity {
    EditText n9, n10, n11;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deducciones);

        //n9 = (EditText) findViewById(R.id.txtirn);
        n10 = (EditText) findViewById(R.id.editText6);
        n11 = (EditText) findViewById(R.id.editText15);

        // Button CalcDeduc = (Button) findViewById(R.id.btnDeducciones);
        Button CalcTotal = (Button) findViewById(R.id.btnTotal);

        final TextView inss = (TextView) findViewById(R.id.txtinss);
        final TextView ir = (TextView) findViewById(R.id.IRmen);
        final TextView deduc = (TextView) findViewById(R.id.txtDeducciones);
        final TextView total = (TextView) findViewById(R.id.ResulTotalaRecibir);
        final TextView irM = (TextView) findViewById(R.id.IRquinc);

        CalcTotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //float num1 = new Float(n9.getText().toString());
                float num2 = new Float(n10.getText().toString());
                float num3 = new Float(n11.getText().toString());
                float laboral = (float) 0.0625;

                double base = 0.0d;
                double desde = 0.0d;
                double exceso = 0.0d;
                double hasta = 0.0d;
                float porcentaje = 0;

                Bundle bundle=getIntent().getExtras();
                float value=Float.parseFloat(bundle.getString("resultado"));


                float seguro = (value * laboral);
                float inssmensual = (value - seguro);

                float anual = (inssmensual * 12);

                if (anual <= 100000.0d) {
                    porcentaje = (float) 0.0d;
                    base = 0.0d;
                    exceso = 0.0d;
                } else if (anual <= 200000.0d) {
                    porcentaje = (float) 0.15d;
                    base = 0.0d;
                    exceso = 100000.0d;
                } else if (anual <= 350000.0d) {
                    porcentaje = (float) 0.2d;
                    base = 15000.0d;
                    exceso = 200000.0d;
                } else if (anual <= 500000.0d) {
                    porcentaje = (float) 0.25d;
                    base = 45000.0d;
                    exceso = 350000.0d;
                } else {
                    porcentaje = (float) 0.3d;
                    base = 82500.0d;
                    exceso = 500000.0d;
                }

                double iranual = ((anual - exceso) * porcentaje) + base;
                double irmensual = (iranual / 12.0d);
                double irquincenal = (irmensual / 2.0d);
                double salarioNeto = (value - irmensual) - seguro;


                double resibe = (salarioNeto - num2) - num3;
                double totaldeduc = (inssmensual + irmensual + num2 + num3);

                inss.setText(String.format( " %.2f",seguro));
                ir.setText(String.format( "%.2f",irmensual));
                irM.setText(String.format( "%.2f",irquincenal));
                deduc.setText(String.format( "%.2f",totaldeduc));
                total.setText(String.format( "%.2f",resibe));

            }

            ;
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Deducciones Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

