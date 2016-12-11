package com.nicarial.nicarial;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Ingresos extends AppCompatActivity {

    EditText n1,n2,n3,n4,n5,n6,n7,n8;
    Button cal;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresos);

        n1 = (EditText) findViewById(R.id.editText3);
        //n2 = (EditText) findViewById(R.id.editText5);
        n3 = (EditText) findViewById(R.id.editText7);
        //n4 = (EditText) findViewById(R.id.editText8);
        n5 = (EditText) findViewById(R.id.editText9); //Horas Extras
        n6 = (EditText) findViewById(R.id.editText10);
        n7 = (EditText) findViewById(R.id.editText11);


        Button CalcIng = (Button) findViewById(R.id.btnIngresos);

        final TextView ing = (TextView) findViewById(R.id.txt);
        final TextView hr = (TextView) findViewById(R.id.textHoras);
        final TextView vac = (TextView) findViewById(R.id.txtVacas);

        CalcIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float num1 = new Float(n1.getText().toString());
                //float num2 = new Float(n2.getText().toString());
                float num3 = new Float(n3.getText().toString());
                //float num4 = new Float(n4.getText().toString());
                float num5 = new Float(n5.getText().toString());//Horas Extras
                float num6 = new Float(n6.getText().toString());
                float num7 = new Float(n7.getText().toString());
        int horasDiarias = 8;
        float vaca= (float) 2.5;
        float resulHoras = ((((num3/num1)/(horasDiarias))*(num5))*2);
        float resulvacas = ((num3/num1)*vaca);
        float resultado = (num1+num3+num6+num7+resulHoras+vaca);
        vac.setText(""+resulvacas);
        ing.setText(""+resultado);
        hr.setText(""+resulHoras);

                Intent Resul = new Intent(Ingresos.this, DeduccionesActivity.class);
                Resul.putExtra("resultado", resultado);


                Button Calc = (Button) findViewById(R.id.btnDedu);
                //Calc = (Button) findViewById(R.id.btnDedu);
                 //CalcDe= (Button) findViewById(R.id.btnDedu);

                Calc.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(Ingresos.this, DeduccionesActivity.class));
                    }
                });

    }
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
                .setName("Ingresos Page") // TODO: Define a title for the content shown.
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
